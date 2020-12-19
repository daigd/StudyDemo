package com.dgd.spark.core.doubleValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_intersection {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3, 5))
  val rdd2: RDD[Int] = sc.makeRDD(List(3, 4, 4, 5, 6))
    // intersection 算子:对两个RDD取交集
    val intersectionRDD: Array[Int] = rdd1.intersection(rdd2).collect()
    intersectionRDD.foreach(println)
    // 如果数据类型不一样,编译报错
//    val rdd3: RDD[String] = sc.makeRDD(List("2", "Hadoop"))
//    rdd1.intersection(rdd3)
  }
}
