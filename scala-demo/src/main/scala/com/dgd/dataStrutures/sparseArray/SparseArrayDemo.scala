package com.dgd.dataStrutures.sparseArray

import scala.collection.mutable.ArrayBuffer

/**
 * @author : DaiGD
 * @createtime :  2020年12月31日 17:34
 * @description : 
 */
object SparseArrayDemo {
  def main(args: Array[String]): Unit = {
    val towDimArray = Array.ofDim[Int](11, 11)
    // 设置数据
    towDimArray(2)(4) = 1
    towDimArray(3)(8) = 2
    towDimArray(0)(2) = 1
    towDimArray(4)(2) = 2

    println("数组长度", towDimArray.length)
    println("数组列数", towDimArray(0).length)
    val datas = new ArrayBuffer[Chess]()
    datas.append(Chess(towDimArray.length, towDimArray(0).length, 0))
    println("datas:", datas)

    // 1.将原数据数据保存到稀疏数组中
    for (i <- towDimArray.indices) {
      for (j <- towDimArray(i).indices) {
        if (towDimArray(i)(j) != 0) {
          datas.append(Chess(i, j, towDimArray(i)(j)))
        }
      }
    }

    println("====输出稀疏数据保存数据======")
    for (arr <- datas.toArray) {
      println(arr + "\t")
    }

    // 2.将数组还原
    println("====将稀疏数组数据还原======")
    val array = Array.ofDim[Int](datas(0).row, datas(0).col)
    for (idx <- datas.indices) {
      if (idx != 0) {
        val data = datas(idx)
        array(data.row)(data.col) = data.value
      }
    }
    // 3.数据显示
    for (a <- array) {
      for (v <- a) {
        print(v + "\t")
      }
      println()
    }
  }

}



