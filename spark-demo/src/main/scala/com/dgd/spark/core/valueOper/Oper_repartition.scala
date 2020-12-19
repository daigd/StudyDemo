package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_repartition {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 3, 2, 1, 3, 4, 5))
    //    rdd.saveAsTextFile("in1")
    // repartition 算子重新分配分区:底层调用的 coalesce 方法,会有 shuffle 过程
    println("分区数:" + rdd.getNumPartitions)
    val repartitionRDD: RDD[Int] = rdd.repartition(6)
    //    repartitionRDD.saveAsTextFile("out1")
    println("重新分配分区数:"+repartitionRDD.getNumPartitions)
  }
}
