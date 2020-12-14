package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_mapPartitions {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc: SparkContext = new SparkContext(conf)

    // mapPartitions 可能会导致OOM
    val rdd: RDD[Int] = sc.makeRDD(1 to 10)
    val pRDD: RDD[Int] = rdd.mapPartitions(datas => {
      datas.map(_*2)
    })
    pRDD.collect().foreach(println)
  }
}
