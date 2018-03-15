package com.dgd.decorator;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public class Client {
    public static void main(String[] args) {
        //装饰对象
        Component component = new ConcreteComponent();

        //对计算的奖金进行装饰
        //各个装饰器之间最好不要有先后顺序的限制
        //先组合普通业务人员的奖金计算

        Decorator decorator1 = new MonthPrizeDecorator(component);
        Decorator decorator2 = new SumPrizeDecorator(decorator1);

        System.out.printf("张三应得奖金 : %f\n", decorator2.calPrize("张三", null, null));
        System.out.printf("李四应得奖金 : %f\n", decorator2.calPrize("李四", null, null));

        //如果是业务经理，还要计算一个团队奖金
        Decorator decorator3 = new GroupPrizeDecorator(decorator2);
        System.out.printf("王五应得奖金 : %f\n", decorator3.calPrize("王五", null, null));

    }
}
