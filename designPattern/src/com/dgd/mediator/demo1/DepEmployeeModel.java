package com.dgd.mediator.demo1;

/**
 * @Author DGD
 * @date 2017/10/30.
 * 部门员工关系维护表
 */
public class DepEmployeeModel {
    private String modelId;
    private String depId;
    private String employeeId;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
