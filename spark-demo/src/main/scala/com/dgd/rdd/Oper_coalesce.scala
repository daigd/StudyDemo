package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_coalesce {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc: SparkContext = new SparkContext(conf)

    // 创建一个RDD,对分区数进行合并
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 9, 8, 2, 4, 9, 1, 7))
    println("合并前分区数:" + rdd.getNumPartitions)
    val coalesceRDD: RDD[Int] = rdd.coalesce(2)
    println("合并后分区数:"+coalesceRDD.getNumPartitions)
  }
}
