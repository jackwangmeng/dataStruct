package com.wm.desiger.Factory;

public class CarTest {
    public static void main(String[] args) {
        //从工厂中创建对象
        ICar obj = CarSimpleFactory.create("toptype");
    }
}
