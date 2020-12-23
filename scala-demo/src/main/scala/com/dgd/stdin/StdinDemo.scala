package com.dgd.stdin

import scala.io.StdIn

object StdinDemo {
  def main(args: Array[String]): Unit = {
    println("请输入姓名:")
    val name: String = StdIn.readLine()
    println("请输入年龄:")
    val age: Int = StdIn.readInt()
    println("请输入薪水:")
    val salary: Double = StdIn.readDouble()
    printf("结果=>姓名:%s,年龄:%d,薪水:%.2f", name, age, salary)
  }
}
