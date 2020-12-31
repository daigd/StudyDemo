package com.dgd.collection.array

/**
 * @author : DaiGD
 * @createtime :  2020年12月30日 10:45
 * @description : 
 */
object ArrayDemo {
  def main(args: Array[String]): Unit = {
    // 定长数组
    // 创建方式1：
    val row = 10
    val arr = new Array[Int](row)
    println("数组长度", arr.length)
    for (value <- arr) {
      print(value + "\t")
    }
    println()
    // 创建方式2：
    val arr2 = Array("Java", "Scala", "Go")
    for (value <- arr2) {
      print(value + "\t")
    }
    println()
    // 创建二维数组
    val towDimArray = Array.ofDim[Int](2, 3)
    println(towDimArray, towDimArray.getClass)


  }
}
