package com.dgd.spark.core.doubleValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_zip {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3))
    val rdd2: RDD[Int] = sc.makeRDD(List(4, 5, 6))
    // zip 算子:对两个RDD数据以 key-value 形式进行合并
    // 对两个 RDD 要求：1,分区数一样;2,每个分区内数据数目一致
    rdd1.zip(rdd2).collect().foreach(println)
    println("==============================")
    val rdd3: RDD[String] = sc.makeRDD(List("2", "3","5"))
    rdd1.zip(rdd3).collect().foreach(println)


  }
}
