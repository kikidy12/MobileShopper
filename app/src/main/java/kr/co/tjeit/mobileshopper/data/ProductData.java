package kr.co.tjeit.mobileshopper.data;

import java.io.Serializable;

/**
 * Created by the on 2017-08-01.
 */

public class ProductData implements Serializable {
    private String name;
    private int price;
    private int count;
    private int imgNum;

    public ProductData() {
    }

    public ProductData(String name, int price, int count, int imgNum) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.imgNum = imgNum;
    }

    public ProductData(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getImgNum() {
        return imgNum;
    }

    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
