package com.wm.desiger.abstruct;

public class InteLess implements ILess<Integer> {
    @Override
    public boolean less(Integer x, Integer y) {
        return x < y;
    }
}
