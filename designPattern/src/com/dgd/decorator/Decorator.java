package com.dgd.decorator;

import java.util.Date;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public abstract class Decorator extends Component {
    //持有被装饰的组件对象
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public double calPrize(String user, Date start, Date end) {
        //转调组件对象的方法
        return component.calPrize(user, start, end);
    }
}
