package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_map {

  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[String] = sc.makeRDD(List("Hadoop","Spark","Hive","Spark","Java","Scala","Hadoop"))
    // map 算子的演示
    // 1.1 数据类型的转换
    val rdd2: RDD[String] = sc.makeRDD(Array("1", "2", "3", "4", "5"))
    val intRDD: RDD[Int] = rdd2.map(x => x.toInt)
    intRDD.foreach(println)
    // 1.2 数据结构的转换
    val mapRDD: RDD[(String, Int)] = rdd.map(x => (x, 1))
    mapRDD.foreach(println)

  }
}
