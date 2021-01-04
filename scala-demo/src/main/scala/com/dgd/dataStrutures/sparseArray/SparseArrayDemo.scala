package com.dgd.dataStrutures.sparseArray

import java.io.{BufferedReader, FileReader, FileWriter}

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

    println("====输出稀疏数据保存数据至本地文件======")
    val w = new FileWriter("chess.data")
    for (arr <- datas.toArray) {
      println(arr)
      w.write(arr+"\n")
    }
    w.close()

    // 2.将数组还原
    println("====读取本地文件将稀疏数组数据还原======")
    // 2.1 从文件中读取内容
    val r = new BufferedReader(new FileReader("chess.data"))
    var line = r.readLine()
    val dataBuffer = new ArrayBuffer[Chess]
    while (line!=null) {
      val arr = line.split(",")
      dataBuffer.append(Chess(arr(0).toInt,arr(1).toInt,arr(2).toInt))
      line = r.readLine()
    }
    
    // 2.2 数据还原
    val dataArray = dataBuffer.toArray
    val array = Array.ofDim[Int](dataArray(0).row, dataArray(0).col)
    for (idx <- dataArray.indices) {
      if (idx != 0) {
        val data = dataArray(idx)
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



