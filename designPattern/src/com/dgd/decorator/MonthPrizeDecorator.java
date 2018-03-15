package com.dgd.decorator;

import java.util.Date;

/**
 * @Author DGD
 * @date 2018/3/15.
 * 装饰器对象，计算当月的奖金
 */
public class MonthPrizeDecorator extends Decorator {
    public MonthPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calPrize(String user, Date start, Date end) {
        //先获取前面计算出来的奖金
        double money = super.calPrize(user, start, end);
        //计算当月的奖金
        double prize = TempDB.monthSaleMoney.get(user) * 0.03;
        System.out.printf("%s 当月业务奖金 : %f\n", user, prize);
        return money + prize;
    }
}
