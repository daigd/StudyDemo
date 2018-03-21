package com.dgd.composite;

/**
 * @Author DGD
 * @date 2018/3/19.
 * 叶子对象
 */
public class Leaf extends Component{
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    /**
     * 输出叶子对象的结构，叶子对象没有子组件，直接输出名字即可
     * @param preStr
     */
    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);
    }
}
