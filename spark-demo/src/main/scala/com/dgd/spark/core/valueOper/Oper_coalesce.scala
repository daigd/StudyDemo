package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_coalesce {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 3, 2, 1, 3, 4, 5))
    rdd.saveAsTextFile("in1")
    // coalesce 算子,合并分区以提高数据执行效率
    println("当前分区数:" + rdd.getNumPartitions)
    val coalesceRDD: RDD[Int] = rdd.coalesce(2)
    coalesceRDD.saveAsTextFile("out1")
    println("合并后分区数:"+coalesceRDD.getNumPartitions)

  }
}
