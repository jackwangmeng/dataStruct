package com.wm.desiger.Factory;

public class CarSimpleFactory {
    public static final String TOPTYPE = "toptype";
    public static final String MIDTYPE = "midtype";
    public static final String LOWTYPE = "lowtype";

    public static ICar create (String mark){
        ICar obj = null;
        if (mark.equals(TOPTYPE)){
            obj = new TopCar();
        }else if (mark.equals(MIDTYPE)){
            obj = new MidCar();
        }else if(mark.equals(LOWTYPE)){
            obj = new LowCar();
        }
        return obj;
    }

}
