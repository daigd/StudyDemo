package com.dgd.decorator;

import java.util.Date;

/**
 * @Author DGD
 * @date 2018/3/15.
 * 装饰器对象，计算团队当月奖金
 */
public class GroupPrizeDecorator extends Decorator {
    public GroupPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calPrize(String user, Date start, Date end) {
        //获取前面计算出来的奖金
        double money = super.calPrize(user, start, end);
        //计算团队总的业务额，再乘以1%，假设都是同一个团队的
        double group = 0.0;
        for (double d : TempDB.monthSaleMoney.values()) {
            group += d;
        }
        double prize = group * 0.01;
        System.out.printf("%s 当月团队业务奖金 : %f\n", user, prize);
        return money + prize;
    }
}
