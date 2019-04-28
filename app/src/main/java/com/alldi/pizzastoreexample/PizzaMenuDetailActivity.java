package com.alldi.pizzastoreexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alldi.pizzastoreexample.databinding.ActivityPizzaMenuDetailBinding;

public class PizzaMenuDetailActivity extends BaseActivity {

    ActivityPizzaMenuDetailBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setValues();
        setupEvents();

    }

    @Override
    public void setupEvents() {



    }

    @Override
    public void setValues() {




    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_pizza_menu_detail);
    }
}
