package com.alldi.pizzastoreexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    Context mContext;

    public abstract void setupEvents();
    public abstract void setValues();
    public abstract void bindViews();


}
