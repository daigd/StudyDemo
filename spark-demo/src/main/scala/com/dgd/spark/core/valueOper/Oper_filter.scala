package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_filter {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5))
    // filter 算子：按指定策略进行过滤，分区不变，数据可能会出现不均衡，生产环境可能会产生数据倾斜
    //    rdd.saveAsTextFile("groupByBefore")
    // 需求：按数据是否整除2进行过滤
    val filter: RDD[Int] = rdd.filter(x => x % 2 == 0)
    filter.foreach(println)

  }
}
