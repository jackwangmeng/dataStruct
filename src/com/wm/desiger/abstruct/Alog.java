package com.wm.desiger.abstruct;

public class Alog<T> {
    public T getMax(T t[], ILess<T> cmp){
        T maxValue = t[0];

        for (int i = 1; i < t.length; i++){
            if (cmp.less(maxValue,t[i]));
        }
        return maxValue;
    }

}
