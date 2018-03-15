package com.dgd.decorator;

import java.util.Date;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public class ConcreteComponent extends Component {

    //计算奖金的默认实现
    @Override
    public double calPrize(String user, Date start, Date end) {
        return 0;
    }
}
