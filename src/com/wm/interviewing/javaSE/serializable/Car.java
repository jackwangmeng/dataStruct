package com.wm.interviewing.javaSE.serializable;

import java.io.Serializable;

/**
 * @author wm
 * @Package com.wm.interviewing.javaSE.serializable
 * @date 2021/1/14 17:29
 */
class Car implements Serializable {

    private static final long serialVersionUID = -5713945027627603702L;

    private String brand; // 品牌

    private int maxSpeed; // 最高时速


    public Car(String brand, int maxSpeed) {
         this.brand = brand;
         this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
         return brand;
    }

    public void setBrand(String brand) {
         this.brand = brand;
    }

    public int getMaxSpeed() {
         return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
         this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
    }
}
