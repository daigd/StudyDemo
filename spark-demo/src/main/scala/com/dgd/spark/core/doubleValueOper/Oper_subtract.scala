package com.dgd.spark.core.doubleValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_subtract {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5))
    val rdd2: RDD[Int] = sc.makeRDD(List(4, 5, 6))
//    rdd1.saveAsTextFile("in1")
    // subtract 算子:对两个RDD取差集:以调用RDD为主,去除重复的元素
    val subtractRDD: RDD[Int] = rdd1.subtract(rdd2)
//    subtractRDD.saveAsTextFile("out1")
    subtractRDD.collect().foreach(println)
    println("================================")
    rdd2.subtract(rdd1).collect().foreach(println)

  }
}
