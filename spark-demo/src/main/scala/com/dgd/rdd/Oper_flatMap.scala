package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_flatMap {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc: SparkContext = new SparkContext(conf)

    val rdd: RDD[List[Int]] = sc.makeRDD(Array(List(1, 2), List(3, 4)))

    val flatMapRDD: RDD[Int] = rdd.flatMap(datas=>datas)
    flatMapRDD.collect().foreach(println)

  }
}
