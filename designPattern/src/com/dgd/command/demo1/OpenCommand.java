package com.dgd.command.demo1;

/**
 * @Author DGD
 * @date 2017/10/31.
 * 开机命令,实现命令接口
 */
public class OpenCommand implements Command {
    private Mainboard mainboard;

    public Mainboard getMainboard() {
        return mainboard;
    }

    public void setMainboard(Mainboard mainboard) {
        this.mainboard = mainboard;
    }

    @Override
    public void execute() {
        //真正开机命令的执行,其实转给主板去执行
        this.mainboard.open();
    }
}
