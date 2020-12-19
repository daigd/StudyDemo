package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_groupBy {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[String] = sc.makeRDD(List("Hadoop", "hive", "hive", "Java", "java"))
    // groupBy 算子：按指定策略进行分组,分区数不变，但会打乱重组
//    rdd.saveAsTextFile("groupByBefore")
    // 需求：将数据按照首字母进行分组
    val groupByRDD: RDD[(Char, Iterable[String])] = rdd.groupBy(x => x.charAt(0))
//    groupByRDD.saveAsTextFile("groupByAfter")
    groupByRDD.foreach(println)
  }
}
