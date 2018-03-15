package com.dgd.decorator;

import java.util.Date;

/**
 * @Author DGD
 * @date 2018/3/15.
 * 计算奖金的组件接口
 */
public abstract class Component {
    /**
     * 计算某人在某段时间内的奖金
     * @param user 被计算奖金的人员
     * @param start 计算奖金的开始时间
     * @param end 计算奖金的结束时间
     * @return 某人在某段时间内的奖金
     */
    public abstract double calPrize(String user, Date start, Date end);
}
