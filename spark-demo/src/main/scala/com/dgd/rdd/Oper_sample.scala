package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_sample {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc: SparkContext = new SparkContext(conf)

    // 创建一个RDD,对元素进行取样
    val rdd: RDD[Int] = sc.makeRDD(1 to 10)
    val sampleRDD: RDD[Int] = rdd.sample(false, 0.6, 1)
    sampleRDD.collect().foreach(println)


  }
}
