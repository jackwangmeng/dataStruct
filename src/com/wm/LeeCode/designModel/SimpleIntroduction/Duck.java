package com.wm.leecode.designModel.SimpleIntroduction;

/**
 * @author 王萌
 * @version V2.0
 * @Package com.wm.leecode.designModel
 * @date 2020/7/17 15:37
 * @Copyright © 2020- 北京建设数字科技股份有限公司
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck(){}

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys");
    }
}
