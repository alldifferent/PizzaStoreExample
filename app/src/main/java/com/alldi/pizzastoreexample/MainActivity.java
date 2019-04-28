package com.alldi.pizzastoreexample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.alldi.pizzastoreexample.adapters.PizzaStoreAdapter;
import com.alldi.pizzastoreexample.databinding.ActivityMainBinding;
import com.alldi.pizzastoreexample.datas.PizzaStore;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    List<PizzaStore> pizzaStoreList = new ArrayList<>();
    PizzaStoreAdapter pizzaStoreAdapter;
    static int RES_REQUEST_CODE = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();

        fillStore();
        setValues();
        setupEvents();

    }

    @Override
    public void setupEvents() {

       act.pizzaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               PizzaStore pizzaStoreData = pizzaStoreList.get(position);

               Intent intent = new Intent(MainActivity.this, PizzaMenuDetailActivity.class);
               intent.putExtra("앱정보", pizzaStoreData);
               startActivityForResult(intent, RES_REQUEST_CODE);
           }
       });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RES_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String storeNameStr = data.getStringExtra("가게이름");
                String pizzaMenuStr = data.getStringExtra("메뉴");
                Toast.makeText(this, String.format("%s에서 %s를 주문하였습니다.",storeNameStr,pizzaMenuStr), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "주문을 취소하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void setValues() {

        pizzaStoreAdapter = new PizzaStoreAdapter(MainActivity.this, pizzaStoreList);
        act.pizzaList.setAdapter(pizzaStoreAdapter);

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setTitle("피자 주문 앱");
    }

    public void fillStore(){

        pizzaStoreList.add(new PizzaStore("파파존스", "06:00~21:00", "010-1234-5678", "https://is4-ssl.mzstatic.com/image/thumb/Purple123/v4/9b/ca/14/9bca14b8-1604-c939-664d-64aea4f37606/AppIcon-0-1x_U007emarketing-0-0-85-220-0-8.png/246x0w.jpg"));
        pizzaStoreList.add(new PizzaStore("피자헛", "09:00~22:00", "010-4533-3849", "https://upload.wikimedia.org/wikipedia/en/thumb/d/d2/Pizza_Hut_logo.svg/220px-Pizza_Hut_logo.svg.png"));
        pizzaStoreList.add(new PizzaStore("도미노피자", "12:00~20:00", "010-9933-4324", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Domino%27s_pizza_logo.svg/120px-Domino%27s_pizza_logo.svg.png"));
        pizzaStoreList.add(new PizzaStore("미스터피자", "09:30~21:30", "010-7754-3245", "data:image/png;base64,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"));
        pizzaStoreList.add(new PizzaStore("피자에땅", "11:00~21:00", "010-4523-4567", "https://mblogthumb-phinf.pstatic.net/20160530_214/ppanppane_1464617804922knKn4_PNG/%C7%C7%C0%DA%BF%A1%B6%A5_%B7%CE%B0%ED_%282%29.png?type=w800"));
        pizzaStoreList.add(new PizzaStore("피자스쿨", "12:00~22:00", "010-9283-7788", "https://modo-phinf.pstatic.net/20150501_269/1430484184544WKwLF_JPEG/mosa7NPaR2.jpeg?type=f320_320"));
    }
}
