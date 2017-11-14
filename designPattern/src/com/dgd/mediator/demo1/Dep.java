package com.dgd.mediator.demo1;

/**
 * @Author DGD
 * @date 2017/10/30.
 * 部门实体类
 */
public class Dep {
    //部门ID
    private String depId;
    //部门名称
    private String depName;

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    //撤销部门
    public boolean deleteDep(String depId) {
        MediatorImpl mediator = MediatorImpl.getInstance();
        return mediator.deleteDep(depId);
    }

}
