package com.dgd.decorator;

import java.util.Date;

/**
 * @Author DGD
 * @date 2018/3/15.
 * 装饰器对象，计算累计奖金
 */
public class SumPrizeDecorator extends Decorator {
    public SumPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calPrize(String user, Date start, Date end) {
        //获取前面计算的奖金
        double money = super.calPrize(user, start, end);
        //简单模拟一下，假设大家的累计业务额都是100000元
        double prize = 100000 * 0.001;
        System.out.printf("%s 累计奖金 : %f\n", user, prize);
        return money + prize;
    }
}
