package com.dgd.command.demo1;

/**
 * @Author DGD
 * @date 2017/10/31.
 * 技嘉主板
 */
public class GigaMainboard implements Mainboard {
    //真正的开机命令实现
    @Override
    public void open() {
        System.out.println("技嘉主板正在开机,请稍候");
        System.out.println("接通电源...");
        System.out.println("检查设备...");
        System.out.println("装载系统...");
        System.out.println("机器正常运转起来...");
        System.out.println("机器已经正常打开,请操作");
    }
}
