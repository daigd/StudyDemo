package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_flatMap {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[String] = sc.makeRDD(List("Hadoop Hive", "Spark Kafka Hive", "Hive Java Hadoop"))
    // latMap 算子的演示:将数据扁平化
    rdd.flatMap(x=>x.split(" ")).foreach(println)
    val listRDD: RDD[List[Int]] = sc.makeRDD(List(List(1, 2), List(3, 4)))
    val intRDD: RDD[Int] = listRDD.flatMap(x => x)
    intRDD.foreach(println)
  }
}
