package com.dgd.facade;

/**
 * @author Dgd
 * @Description 不使用外观（门面）模式的客户端，要直接与子系统交互（要了解子系统的实现细节，增加了难度）
 * @date 2018-05-04 15:53
 */
public class WithoutFacadeClient {
    public static void main(String[] args) {
        System.out.println("开启保安系统:");
        Camera camera = new Camera();
        Ligtht ligtht = new Ligtht();
        Sensor sensor = new Sensor();
        camera.turnOn();
        ligtht.turnOn();
        sensor.activate();
        System.out.println("关闭保安系统:");
        camera.turnOff();
        ligtht.turningOff();
        sensor.deactivate();
    }
}
