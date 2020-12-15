package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_sortBy {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)

    // 对 Value 进行排序
    val rdd: RDD[Int] = sc.makeRDD(List(2, 3, 1, 9, 4, 5))
    // 默认顺序排序
    val sortRDD: RDD[Int] = rdd.sortBy(x => x)
    sortRDD.collect().foreach(println)
    // 倒序排序
    val sortRDD2: RDD[Int] = rdd.sortBy(x => x, false)
    sortRDD2.collect().foreach(println)
  }
}
