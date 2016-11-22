package cn.mycommons.goodsdemo;

import java.io.Serializable;

/**
 * GoodsItem <br/>
 * Created by xiaqiulei on 2016-11-22.
 */
public class GoodsItem implements Serializable {

    public String name;

    public int count;

    public double price;

    @Override
    public String toString() {
        return "GoodsItem{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}