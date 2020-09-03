package com.wm.leecodes.designModel.SimpleIntroduction;

import com.wm.leecodes.designModel.SimpleIntroduction.impl.FlyWithWings;
import com.wm.leecodes.designModel.SimpleIntroduction.impl.Quack;

/**
 * @author 王萌
 * @version V2.0
 * @Package com.wm.leecode.designModel.SimpleIntroduction
 * @date 2020/7/17 15:56
 * @Copyright © 2020- 北京建设数字科技股份有限公司
 */
public class MallardDuck extends Duck{

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
