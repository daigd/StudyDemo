package com.dgd.spark.core.keyValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_groupByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("b", 1), ("c", 1), ("a", 1)))
    // groupByKey 算子:按照相同的key进行分组
    // 跟reduceByKey有啥区别?
    // 1. reduceByKey 包含分组和聚合的功能,有预聚合阶段,效率高,推荐使用;
    // 2. groupByKey 只有分组功能

    val groupByKeyRDD: RDD[(String, Iterable[Int])] = rdd.groupByKey()
    groupByKeyRDD.collect().foreach(println)

  }
}
