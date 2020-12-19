package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_glom {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 3)
    // glom 算子：将同一分区的数据转换成数组
    // 需求：同一分区取最大值，再求和
    val glomRDD: RDD[Array[Int]] = rdd.glom()
    // 输出每个数组的内容
    glomRDD.foreach(array=>println(array.mkString(",")))
    val sum: Int = glomRDD.map(array => {
      array.max
    }).reduce(_ + _)
    println(sum)

  }
}
