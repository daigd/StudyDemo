package com.dgd.command.demo2;

/**
 * @Author DGD
 * @date 2017/11/1.
 * 减法命令
 */
public class SubCommand implements Command {
    private OperationApi operationApi;
    private int num;

    public SubCommand(OperationApi operationApi, int num) {
        this.operationApi = operationApi;
        this.num = num;
    }

    @Override
    public void execute() {
        this.operationApi.substract(num);
    }

    @Override
    public void undo() {
        this.operationApi.add(num);
    }
}
