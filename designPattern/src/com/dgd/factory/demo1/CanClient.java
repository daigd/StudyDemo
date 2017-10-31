package com.dgd.factory.demo1;

/**
 * @Author DGD
 * @date 2017/10/31.
 * 测试罐头工厂
 */
public class CanClient {
    public static void main(String[] args) {
        //默认的罐头实现
        Can can = CanFactory.createCan();
        can.show();

        //选择性的生产水果罐头
        Can can1 = CanFactory.createCan(Can.CANNED_FRUITS);
        can1.show();
    }
}
