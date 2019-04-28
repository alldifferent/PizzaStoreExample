package com.alldi.pizzastoreexample.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alldi.pizzastoreexample.PizzaMenuDetailActivity;
import com.alldi.pizzastoreexample.R;
import com.alldi.pizzastoreexample.datas.PizzaStore;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PizzaStoreAdapter extends ArrayAdapter<PizzaStore> {

    Context mContext;
    List<PizzaStore> mList;
    LayoutInflater inf;


    public PizzaStoreAdapter(Context context, List<PizzaStore> list){

        super(context, R.layout.pizza_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null){
            row = inf.inflate(R.layout.pizza_list_item, null);
        }

        PizzaStore pizzaStoreData = mList.get(position);

        TextView storeNameTxt = row.findViewById(R.id.storeNameTxt);
        TextView openTimeTxt = row.findViewById(R.id.openTimeTxt);
        CircleImageView storeImgView = row.findViewById(R.id.storeImgView);

        storeNameTxt.setText(pizzaStoreData.storeName);
        openTimeTxt.setText(pizzaStoreData.openTime);
        Glide.with(mContext).load(pizzaStoreData.imgUri).into(storeImgView);





        return row;
    }


}
