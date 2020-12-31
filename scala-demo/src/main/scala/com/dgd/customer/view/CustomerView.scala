package com.dgd.customer.view

import com.dgd.customer.bean.Customer
import com.dgd.customer.service.CustomerService

import scala.io.StdIn

/**
 * @author : DaiGD
 * @createtime :  2020年12月31日 15:12
 * @description : 
 */
class CustomerView {

  val service = new CustomerService

  def show(): Unit = {
    var loop = true
    do {
      println("=================员工管理系统================")
      println("                 1 添加员工                  ")
      println("                 2 查看员工列表              ")
      println("                 3 查看员工                  ")
      println("                 4 删除员工                  ")
      println("                 5 退出系统                  ")
      println("请输入(1-5):")
      StdIn.readLine() match {
        case "1" => add()
        case "2" => list()
        case "3" => get()
        case "4" => del()
        case "5" =>
          loop = false
        case _ => println("功能无法识别")
      }
    } while (loop)
    println("你已退出系统")
  }


  def add(): Unit = {
    println("===========添加员工===========")
    println("请输入姓名:")
    val name = StdIn.readLine()
    println("请输入年龄:")
    val age = StdIn.readInt()
    println("请输入性别:")
    val gender = StdIn.readChar()
    println("请输入邮箱:")
    val email = StdIn.readLine()
    if (!service.add(new Customer(name, age, gender, email))) {
      println("添加失败!!!")
    }
    println("添加员工完成")
  }

  def list(): Unit = {
    println("===========客户列表===========")
    println("编号\t\t姓名\t\t年龄\t\t性别\t\t邮箱")
    for (c <- service.list()) {
      println(c)
    }
    println("客户列表显示")
  }

  def del(): Unit = {
    println("===========删除员工===========")
    println("请输入要删除的员工编号:")
    val id = StdIn.readInt()
    if (service.del(id)) {
      println("删除完成")
    } else {
      println("删除失败!!")
    }
  }

  def get(): Unit = {
    println("===========查看员工===========")
    println("请输入要查看的员工编号:")
    val id = StdIn.readInt()
    val customer = service.get(id)
    if (customer != null) {
      println("===========员工信息===========")
      println("编号\t\t姓名\t\t年龄\t\t性别\t\t邮箱")
      println(customer)
    } else {
      println("找不到员工记录")
    }
  }
}
