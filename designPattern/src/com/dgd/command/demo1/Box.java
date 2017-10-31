package com.dgd.command.demo1;

/**
 * @Author DGD
 * @date 2017/10/31.
 * 机箱
 */
public class Box {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void openButtonPressed() {
        //按下按钮,执行命令
        this.command.execute();
    }
}
