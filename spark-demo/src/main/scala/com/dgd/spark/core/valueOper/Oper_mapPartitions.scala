package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_mapPartitions {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[String] = sc.makeRDD(List("Hadoop","Spark","Hive","Spark","Java","Scala","Hadoop"),2)
    // mapPartitions 算子的演示,将数据以分区为单位发送给Executor处理
    // 可能会导致 OOM
    val mapPartitionsRDD: RDD[String] = rdd.mapPartitions(datas => {
      datas.filter(x => x.contains("H"))
    })
    mapPartitionsRDD.foreach(println)

  }
}
