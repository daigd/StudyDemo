package com.dgd.spark.core.keyValueOper

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_partitionBy {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[(Int, String)] = sc.makeRDD(List((1, "a"), (2, "b"), (3, "c")))
    rdd.saveAsTextFile("in")
    // 按照指定 partitioner 进行区分,默认分区器是 HashPartitioner
    val partitionByRDD: RDD[(Int, String)] = rdd.partitionBy(new HashPartitioner(2))
    partitionByRDD.saveAsTextFile("out1")

  }
}
