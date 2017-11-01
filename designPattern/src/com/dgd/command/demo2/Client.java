package com.dgd.command.demo2;

/**
 * @Author DGD
 * @date 2017/11/1.
 */
public class Client {
    public static void main(String[] args) {
        //最终执行命令的接收者
        Operation operation = new Operation();

        //加法命令
        Command addCommand = new AddCommand(operation,5);
        //减法命令
        Command subCommand = new SubCommand(operation, 2);

        Calculator calculator = new Calculator();
        //组装命令
        calculator.setAddCommand(addCommand);
        calculator.setSubstractCommand(subCommand);

        //模拟加减法
        calculator.addPressed();
        System.out.println("按下加法后:"+operation.getResult());
        calculator.substractPressed();
        System.out.println("按下减法后:" + operation.getResult());

        //模拟撤销命令
        calculator.undoPressed();
        System.out.println("第一次撤销:"+operation.getResult());
        calculator.undoPressed();
        System.out.println("第二次撤销:" + operation.getResult());

        //模拟恢复命令
        calculator.redoPressed();
        System.out.println("第一次恢复:" + operation.getResult());
        calculator.redoPressed();
        System.out.println("第二次恢复:" + operation.getResult());
    }
}
