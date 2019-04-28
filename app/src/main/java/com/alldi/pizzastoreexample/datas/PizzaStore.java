package com.alldi.pizzastoreexample.datas;

public class PizzaStore {

    public String storeName;
    public String openTime;
    public String phoneNum;
    public String imgUri;

    public PizzaStore(String storeName, String openTime, String imgUri, String phoneNum) {
        this.storeName = storeName;
        this.openTime = openTime;
        this.phoneNum = phoneNum;
        this.imgUri = imgUri;
    }
}
