package com.dgd.mediator.demo1;

/**
 * @Author DGD
 * @date 2017/10/30.
 */
public class Client {
    public static void main(String[] args) {
        MediatorImpl mediator = MediatorImpl.getInstance();

        //准备撤销的部门
        Dep dep = new Dep();
        dep.setDepId("d1");

        //准备离职的员工
        Employee employee = new Employee();
        employee.setEmployeeId("e3");
        Dep dep1 = new Dep();
        dep1.setDepId("d3");

        System.out.println("员工离职前:");
        mediator.showDepEmployees(dep1);
        System.out.println("员工离职后:");
        mediator.deleteEmployee(employee.getEmployeeId());
        mediator.showDepEmployees(dep1);

        System.out.println("部门撤销前:");
        Employee employee1 = new Employee();
        employee1.setEmployeeId("e1");

        mediator.showEmployeeDeps(employee1);
        System.out.println("部门撤销后:");
        mediator.deleteDep(dep.getDepId());
        mediator.showEmployeeDeps(employee1);
    }
}
