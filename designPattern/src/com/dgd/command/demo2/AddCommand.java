package com.dgd.command.demo2;

/**
 * @Author DGD
 * @date 2017/11/1.
 * 加法命令
 */
public class AddCommand implements Command {
    private OperationApi operationApi;
    private int num;

    public AddCommand(OperationApi operationApi, int num) {
        this.operationApi = operationApi;
        this.num = num;
    }
    //调用加法的实际执行者
    @Override
    public void execute() {
        this.operationApi.add(num);
    }
    //加法对应的撤销操作就是减法
    @Override
    public void undo() {
        this.operationApi.substract(num);
    }
}
