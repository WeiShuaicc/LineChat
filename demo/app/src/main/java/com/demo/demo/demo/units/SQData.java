package com.demo.demo.demo.units;

/**
 * Created by Administrator on 2017/2/27/027.
 */

public class SQData {

    private String data_time;
    private int num;
    private String str;
    private int key;

    public SQData(int key,String data_time, int num, String str) {
        this.data_time = data_time;
        this.num = num;
        this.str = str;
        this.key=key;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
