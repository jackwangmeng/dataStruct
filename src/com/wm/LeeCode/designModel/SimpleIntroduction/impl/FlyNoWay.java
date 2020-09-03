package com.wm.leecode.designModel.SimpleIntroduction.impl;

import com.wm.leecode.designModel.SimpleIntroduction.FlyBehavior;

/**
 * @author 王萌
 * @version V2.0
 * @Package com.wm.leecode.designModel.SimpleIntroduction.impl
 * @date 2020/7/17 15:47
 * @Copyright © 2020- 北京建设数字科技股份有限公司
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
