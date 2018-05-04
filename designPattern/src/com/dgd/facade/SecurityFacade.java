package com.dgd.facade;

/**
 * @author Dgd
 * @Description 保安系统门面类，封装了对子系统的操作
 * @date 2018-05-04 15:48
 */
public class SecurityFacade {
    private Camera camera;
    private Ligtht ligtht;
    private Sensor sensor;

    public SecurityFacade() {
        this.camera = new Camera();
        this.ligtht = new Ligtht();
        this.sensor = new Sensor();
    }

    //启动保安系统
    public void activate() {
        camera.turnOn();
        ligtht.turnOn();
        sensor.activate();
    }

    //关闭保安系统
    public void deactivate() {
        camera.turnOff();
        ligtht.turningOff();
        sensor.deactivate();
    }
}
