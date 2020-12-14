package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_distinct {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc: SparkContext = new SparkContext(conf)

    // 创建一个RDD,对元素进行去重
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 9, 8, 2, 4, 9, 1, 7))
    val distinctRDD: RDD[Int] = rdd.distinct()
    distinctRDD.collect().foreach(println)
    distinctRDD.saveAsTextFile("output")
  }
}
