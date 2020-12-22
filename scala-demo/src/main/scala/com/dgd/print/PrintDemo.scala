package com.dgd.print

object PrintDemo {
  def main(args: Array[String]): Unit = {
    val str1: String = "Hello"
    val str2: String = " World!"
    println(str1 + str2)

    val name: String = "Tome"
    val age: Int = 34
    val salary: Double = 23899.04
    printf("姓名:%s,年龄:%d,工资:%.2f", name, age, salary)

    println(s"\n姓名:$name,年龄:$age,工资:$salary")
  }
}
