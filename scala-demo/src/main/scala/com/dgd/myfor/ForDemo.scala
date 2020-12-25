package com.dgd.myfor

/**
 * @author : DaiGD
 * @createtime :  2020年12月25日 17:34
 * @description : 
 */
object ForDemo {
  def main(args: Array[String]): Unit = {
    val start: Int = 1
    val end: Int = 10

    // start to end 范围为：[start,end]
    for (i <- start to end) {
      println("to:" + i)
    }
    println("===========================")

    // start until end 范围为: [start,end)
    for (i <- start until end) {
      println("until:" + i)
    }
    println("===========================")
    // for 守卫
    for (i <- start to end if i % 2 == 0) {
      println("守卫:" + i)
    }
  }
}
