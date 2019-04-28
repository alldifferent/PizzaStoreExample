package com.alldi.pizzastoreexample.datas;

import java.io.Serializable;

public class PizzaStore implements Serializable {

    public String storeName;
    public String openTime;
    public String phoneNum;
    public String imgUri;

    public PizzaStore(String storeName, String openTime, String phoneNum, String imgUri) {
        this.storeName = storeName;
        this.openTime = openTime;
        this.phoneNum = phoneNum;
        this.imgUri = imgUri;
    }
}
