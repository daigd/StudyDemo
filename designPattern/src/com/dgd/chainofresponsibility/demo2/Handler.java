package com.dgd.chainofresponsibility.demo2;

/**
 * @Author DGD
 * @date 2017/10/25.
 * 定义通用的职责处理对象
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public Object handlerRequest(RequestModel rm){
        if (successor != null) {
            return this.successor.handlerRequest(rm);
        }else{
            System.out.println("沒有后续处理或者不支持该功能处理");
            return false;
        }
    }
}
