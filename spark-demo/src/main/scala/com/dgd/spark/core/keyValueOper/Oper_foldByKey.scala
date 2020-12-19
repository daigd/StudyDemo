package com.dgd.spark.core.keyValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_foldByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("b", 1), ("c", 1), ("a", 1),("b", 3)),2)
    // foldByKey算子: 分区内和分区间计算规则相同时,就可简化为 foldByKey算子
    val foldByKeyRDD: RDD[(String, Int)] = rdd.foldByKey(0)(_ + _)
    foldByKeyRDD.collect().foreach(println)
  }
}
