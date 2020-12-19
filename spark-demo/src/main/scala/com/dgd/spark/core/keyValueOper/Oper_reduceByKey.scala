package com.dgd.spark.core.keyValueOper

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_reduceByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("b", 1), ("c", 1), ("a", 1)))
    // reduceByKey 算子:按照相同的key对value进行聚合
    rdd.reduceByKey(_+_).collect().foreach(println)
    // 指定分区数
    rdd.reduceByKey(_+_,2).collect().foreach(println)

  }
}
