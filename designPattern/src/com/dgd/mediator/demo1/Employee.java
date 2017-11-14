package com.dgd.mediator.demo1;

/**
 * @Author DGD
 * @date 2017/10/30.
 * 员工实体类
 */
public class Employee {
    //员工ID
    private String employeeId;
    //员工姓名
    private String employeeName;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    //员工离职
    public boolean deleteEmployee(String employeeId) {
        MediatorImpl mediator = MediatorImpl.getInstance();
        return mediator.deleteEmployee(employeeId);
    }
}
