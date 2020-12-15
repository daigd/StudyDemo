package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_filter {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)

    // 过滤算子
    val rdd: RDD[String] = sc.makeRDD(List("Hadoop", "Spark", "Hive", "Java"))
    val filterRDD: RDD[String] = rdd.filter(_.contains("H"))
    filterRDD.collect().foreach(println)

  }
}
