package com.dgd.composite;

/**
 * @Author DGD
 * @date 2018/3/19.
 * 抽象的组件对象
 */
public abstract class Component {
    //输出组件自身的名称
    public abstract void printStruct(String preStr);

    /**
     * 向组合对象中加入组件对象
     * @param child 被加入的组件对象
     */
    public void addChild(Component child) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 从组合对象中移出某个组件对象
     * @param child
     */
    public void removeChild(Component child) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 返回指定索引的组件对象
     * @param index 组件对象的索引，从0开始
     * @return
     */
    public Component getChildren(int index) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
}
