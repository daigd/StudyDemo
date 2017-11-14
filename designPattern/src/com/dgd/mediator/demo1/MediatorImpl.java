package com.dgd.mediator.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DGD
 * @date 2017/10/30.
 * 中介者:使用单例模式创建中介者,因为中介者数量有一个就够了
 */
public class MediatorImpl {

    private static MediatorImpl mediator = new MediatorImpl();

    private MediatorImpl() {
        initData();
    }

    public static MediatorImpl getInstance() {
        return mediator;
    }

    //记录部门和员工的关系记录
    private List<DepEmployeeModel> depEmployeeModelList = new ArrayList<>();
    //初始化测试数据
    private void initData() {
        DepEmployeeModel model1 = new DepEmployeeModel();
        depEmployeeModelList.add(model1);
        model1.setDepId("d1");
        model1.setEmployeeId("e1");
        model1.setModelId("m1");

        DepEmployeeModel model2 = new DepEmployeeModel();
        depEmployeeModelList.add(model2);
        model2.setDepId("d2");
        model2.setEmployeeId("e1");
        model2.setModelId("m2");

        DepEmployeeModel model3 = new DepEmployeeModel();
        depEmployeeModelList.add(model3);
        model3.setDepId("d3");
        model3.setEmployeeId("e3");
        model3.setModelId("m3");

        DepEmployeeModel model4 = new DepEmployeeModel();
        depEmployeeModelList.add(model4);
        model4.setDepId("d3");
        model4.setEmployeeId("e4");
        model4.setModelId("m4");

        DepEmployeeModel model5 = new DepEmployeeModel();
        depEmployeeModelList.add(model5);
        model5.setDepId("d3");
        model5.setEmployeeId("e5");
        model5.setModelId("m5");
    }

    //撤销部门
    public  boolean deleteDep(String depId) {
        for (DepEmployeeModel model : depEmployeeModelList) {
            if (model.getDepId().equals(depId)) {
                depEmployeeModelList.remove(model);
                return true;
            }
        }
        return false;
    }
    //员工离职
    public boolean deleteEmployee(String employeeId) {
        for (DepEmployeeModel model : depEmployeeModelList) {
            if (model.getEmployeeId().equals(employeeId)) {
                depEmployeeModelList.remove(model);
                return true;
            }
        }
        return false;
    }
    //显示部门下所有的员工
    public void showDepEmployees(Dep dep) {
        for (DepEmployeeModel model : depEmployeeModelList) {
            if (model.getDepId().equals(dep.getDepId())) {
                System.out.println("部门编号:"+dep.getDepId()+",下面拥有员工:"+model.getEmployeeId());
            }

        }
    }

    //显示员工所属部门
    public void showEmployeeDeps(Employee employee) {
        for (DepEmployeeModel model : depEmployeeModelList) {
            if (model.getEmployeeId().equals(employee.getEmployeeId())) {
                System.out.println("员工编号:"+employee.getEmployeeId()+",所属部门编号:"+model.getDepId());
            }
        }
    }
}
