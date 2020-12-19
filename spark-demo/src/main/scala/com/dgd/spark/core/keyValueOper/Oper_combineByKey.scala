package com.dgd.spark.core.keyValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_combineByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 10), ("b", 10), ("c", 14), ("a", 18), ("b", 30)))
    // combineByKey 算子: 最通用的对key-value数据进行聚集操作的算子
    // 需求：求每个 key 的平均值
    val combineByKeyRDD: RDD[(String, (Int, Int))] = rdd.combineByKey(
      (_, 1),
      (acc1: (Int, Int), v) => (acc1._1 + v, acc1._2 + 1),
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc2._2 + acc2._2)
    )
    combineByKeyRDD.collect().foreach(x=> println(x._1 + "的平均值:" + x._2._1 / x._2._2))

    // reduceByKey,aggregateByKey,foldByKey,combineByKey 区别？
    // 1,reduceByKey: 相同key第一个数据不进行任何计算,分区间和分区内计算规则相同
    // 2,aggregateByKey: 相同key会和初始值进行计算,分区间和分区内计算规则可以不同
    // 3,foldByKey: aggregateByKey 分区内和分区间计算规则相同的简化版
    // 4,combineByKey: 当发现数据结构不符合要求时,可以让第一个数据转换数据结构,分区内和分区间计算规则可以不同

  }
}
