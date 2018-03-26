package com.dgd.factory.demo1;

/**
 * @Author DGD
 * @date 2017/10/31.
 */
public class CanFactory {
    public static Can createCan() {
        //默认只提供一种实现
        Can can = null;
        try {
            can = (Can) Class.forName("com.dgd.factory.demo1.CannedSardines").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return can;
    }

    public static Can createCan(int type) {
        //根据罐头类型来提供相应的罐头:如果标识是1,生产水果罐头,其它情况生产沙丁鱼罐头
        Can can = null;
        if (Can.CANNED_FRUITS == type) {
            can = new CannedFruits();
        } else {
            can = new CannedSardines();
        }
        return can;
    }
}
