package com.wm.leecodes.designModel.SimpleIntroduction.impl;

import com.wm.leecodes.designModel.SimpleIntroduction.QuackBehavior;

/**
 * @author 王萌
 * @version V2.0
 * @Package com.wm.leecode.designModel.SimpleIntroduction.impl
 * @date 2020/7/17 15:51
 * @Copyright © 2020- 北京建设数字科技股份有限公司
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
