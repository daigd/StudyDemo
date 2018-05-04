package com.dgd.facade;

/**
 * @author Dgd
 * @Description 感应器
 * @date 2018-05-04 15:45
 */
public class Sensor {
    //启动感应器
    public void activate() {
        System.out.println("Activating the sensor.");
    }
    //关闭感应器
    public void deactivate() {
        System.out.println("Deactivating the sensor.");
    }
}
