package com.dgd.spark.core.doubleValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_union {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3))
    val rdd2: RDD[Int] = sc.makeRDD(List(4, 5, 6))
    rdd1.saveAsTextFile("in1")
    // union 算子:对两个RDD取并集，会对分区数进行合并
    val unionRDD: RDD[Int] = rdd1.union(rdd2)
    unionRDD.saveAsTextFile("out1")
    unionRDD.collect().foreach(println)

  }
}
