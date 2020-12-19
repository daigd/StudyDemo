package com.dgd.spark.core.valueOper

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_mapPartitionsWithIndex {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[String] = sc.makeRDD(List("Hadoop","Spark","Hive","Spark","Java","Scala","Hadoop"),3)
    // mapPartitionsWithIndex 算子的演示,将数据以分区为单位发送给Executor处理,可以获取当前分区的索引
    // 可能会导致 OOM
    rdd.mapPartitionsWithIndex((index, datas) => {
      datas.map(datas=>(index,datas))
    }).foreach(println)
    rdd.saveAsTextFile("output")

  }
}
