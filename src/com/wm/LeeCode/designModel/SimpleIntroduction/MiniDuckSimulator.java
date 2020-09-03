package com.wm.leecode.designModel.SimpleIntroduction;

/**
 * @author 王萌
 * @version V2.0
 * @Package com.wm.leecode.designModel.SimpleIntroduction
 * @date 2020/7/17 15:54
 * @Copyright © 2020- 北京建设数字科技股份有限公司
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }
}
