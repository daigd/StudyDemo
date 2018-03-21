package com.dgd.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DGD
 * @date 2018/3/19.
 * 组合对象，可以包含其它的组合对象或者叶子对象
 */
public class Composite extends Component {
    /**
     * 组合对象中包含的子组件对象
     */
    private List<Component> childComponents;
    /**
     * 组合对象的名字
     */
    private String name;

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void addChild(Component child) {
        if (childComponents == null) {
            childComponents = new ArrayList<>();
        }
        childComponents.add(child);
    }

    @Override
    public Component getChildren(int index) {
        return super.getChildren(index);
    }

    /**
     * 输出组合对象自身的结构
     * @param preStr
     */
    @Override
    public void printStruct(String preStr) {
        //先把自己输出出去
        System.out.println(preStr + "+" + this.name);
        //如果还有子组件，输出子组件对象
        if (childComponents != null) {
            preStr += " ";
            for (Component c : childComponents) {
                //递归输出每个子组件对象
                c.printStruct(preStr);
            }
        }
    }
}
