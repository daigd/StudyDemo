package com.dgd.command.demo1;

/**
 * @Author DGD
 * @date 2017/10/31.
 */
public class Client {
    public static void main(String[] args) {
        //机箱
        Box box = new Box();
        //命令对象
        OpenCommand command = new OpenCommand();
        //主板
        Mainboard mainboard = new GigaMainboard();

        command.setMainboard(mainboard);
        box.setCommand(command);

        //执行开机动作
        box.openButtonPressed();
    }
}
