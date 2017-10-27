package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 * 利用抽象工厂模式来实现电脑组装功能,客户可以随意切换装机方案,要保证不同方案下组装的电脑组件一致
 */
public class Client {
    public static void main(String[] args) {
        //方案一:Intel的CPU+技嘉的主板
        AbstractFactory factory = new Schema1();
        ComputerEngineer engineer = new ComputerEngineer();
        engineer.makeComputer(factory);

        //方案二:AMD的CPU+微星的主板
        factory = new Schema2();
        engineer.makeComputer(factory);

    }
}
