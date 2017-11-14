package com.dgd.command.demo2;

/**
 * @Author DGD
 * @date 2017/11/1.
 */
public interface Command {
    //执行命令的操作
    void execute();
    //撤销命令的操作
    void undo();
}
