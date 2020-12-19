package com.dgd.spark.core.keyValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_sortByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 10), ("b", 10), ("c", 14), ("a", 18), ("b", 30)))

    // sortByKey算子:按key进行排序
    rdd.sortByKey().collect().foreach(println)
    println("==========================")
    rdd.sortByKey(false).collect().foreach(println)
  }
}
