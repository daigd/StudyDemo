package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_mapPartitionsWithIndex {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc: SparkContext = new SparkContext(conf)

    // 创建一个RDD,使每个元素所在分区形成一个元组,组成一个新的RDD
    // 使用 mapPartitionsWithIndex 算子
    val rdd: RDD[Int] = sc.makeRDD(1 to 10)
    // 当函数有多个参数时使用模式匹配,方便参数对应
    val pRDD: RDD[(Int, String)] = rdd.mapPartitionsWithIndex {
      case (num, datas) => {
        datas.map((_, "分区号:" + num))
      }
    }
    pRDD.collect().foreach(println)

  }
}
