package com.dgd.customer.app

import com.dgd.customer.view.CustomerView

/**
 * @author : DaiGD
 * @createtime :  2020年12月31日 15:12
 * @description : 一个简易的员工管理系统
 */
object CustomerApp {
  val view = new CustomerView
  def main(args: Array[String]): Unit = {
    view.show()
  }
}
