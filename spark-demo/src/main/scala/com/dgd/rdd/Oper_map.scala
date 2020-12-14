package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_map {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc: SparkContext = new SparkContext(conf)

    // 使用 map 算子，使每个数乘以2返回
    val rdd: RDD[Int] = sc.makeRDD(1 to 10)
    val mapRDD: RDD[Int] = rdd.map(_ * 2)
    mapRDD.collect().foreach(println)
  }
}
