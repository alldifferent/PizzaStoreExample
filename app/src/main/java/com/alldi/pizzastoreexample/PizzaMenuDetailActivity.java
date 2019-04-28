package com.alldi.pizzastoreexample;

import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alldi.pizzastoreexample.databinding.ActivityPizzaMenuDetailBinding;
import com.alldi.pizzastoreexample.datas.PizzaStore;
import com.bumptech.glide.Glide;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

public class PizzaMenuDetailActivity extends BaseActivity {

    ActivityPizzaMenuDetailBinding act;
    PizzaStore pizzaStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setValues();
        setupEvents();

    }

    @Override
    public void setupEvents() {
        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pizzaMenuStr = act.pizzaMenuSpinner.getSelectedItem().toString();

                Intent intent = new Intent();
                intent.putExtra("가게이름",act.storeNameTxt.getText().toString());
                intent.putExtra("메뉴", pizzaMenuStr);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

        act.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final PermissionListener permissionListener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {

                        String storePhoneNumStr = act.phoneNumTxt.getText().toString();
                        Uri uri = Uri.parse(String.format("tel:%s",storePhoneNumStr));
                        Intent intent = new Intent(Intent.ACTION_CALL, uri);
                        startActivity(intent);
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(PizzaMenuDetailActivity.this, "권한이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                };

                TedPermission.with(PizzaMenuDetailActivity.this)
                        .setPermissionListener(permissionListener)
                        .setDeniedMessage("권한을 거부하면 서비스를 사용할 수 없습니다. 사용하고 싶다면 [Setting] > [Permission]에서 권한을 부여하십시오.")
                        .setPermissions(Manifest.permission.CALL_PHONE)
                        .check();

            }
        });


    }

    @Override
    public void setValues() {
        pizzaStore = (PizzaStore) getIntent().getSerializableExtra("앱정보");

        String uri = pizzaStore.imgUri;

        act.storeNameTxt.setText(pizzaStore.storeName);
        act.phoneNumTxt.setText(pizzaStore.phoneNum);
        setTitle(String.format("%s 상세정보",pizzaStore.storeName));
        Glide.with(PizzaMenuDetailActivity.this).load(uri).into(act.storeImgView);

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_pizza_menu_detail);
        }
}
