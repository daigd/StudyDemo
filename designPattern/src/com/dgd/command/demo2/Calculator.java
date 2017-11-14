package com.dgd.command.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DGD
 * @date 2017/11/1.
 * 计算器类：持有加法、减法命令
 */
public class Calculator {
    private Command addCommand;

    private Command substractCommand;

    private List<Command> undoCmds = new ArrayList<>();

    //被撤销的命令集合,在恢复的时候使用
    private List<Command> redoCmds = new ArrayList<>();

    public void setAddCommand(Command addCommand) {
        this.addCommand = addCommand;
    }

    public void setSubstractCommand(Command substractCommand) {
        this.substractCommand = substractCommand;
    }

    /**
     * 提供给客户使用,执行加法功能
     */
    public void addPressed() {
        this.addCommand.execute();
        //把操作命令放在集合里
        undoCmds.add(addCommand);
    }

    /**
     * 提供给客户使用,执行减法功能
     */
    public void substractPressed() {
        this.substractCommand.execute();
        //把命令放在可撤销命令的集合里
        undoCmds.add(substractCommand);
    }

    /**
     * 客户按下撤销命令
     */
    public void undoPressed() {
        if (this.undoCmds.size() > 0) {
            //取出最后一个命令来撤销
            Command command = undoCmds.get(undoCmds.size() - 1);
            command.undo();
            //把命令放到恢复命令的集合
            redoCmds.add(command);
            //删除命令
            undoCmds.remove(command);
        }else{
            System.out.println("没有可撤销的命令");
        }
    }

    /**
     * 客户按下恢复命令
     */
    public void redoPressed() {
        if (this.redoCmds.size() > 0) {
            //取出最后一个命令
            Command command = redoCmds.get(redoCmds.size() - 1);
            //执行命令
            command.execute();
            //把这个命令记录到可撤销命令的集合里
            undoCmds.add(command);
            //删除命令
            redoCmds.remove(command);
        }else{
            System.out.println("没有可恢复的命令");
        }
    }
}
