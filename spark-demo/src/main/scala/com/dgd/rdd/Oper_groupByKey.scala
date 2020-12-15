package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_groupByKey {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("rdd")
    val sc: SparkContext = new SparkContext(conf)

    val rdd: RDD[(String, Int)] = sc.makeRDD(Array(("b", 2), ("a", 3), ("b", 1), ("c", 2), ("a", 4)))
    val groupByKeyRDD: RDD[(String, Iterable[Int])] = rdd.groupByKey()

    groupByKeyRDD.collect().foreach(println)
  }
}
