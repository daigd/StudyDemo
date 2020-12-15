package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_groupBy {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc: SparkContext = new SparkContext(conf)

    // 创建一个RDD,每个元素模以2来进行分组
    val rdd: RDD[Int] = sc.makeRDD(1 to 10)
    // 分组的条件由函数决定
    val groupByRDD: RDD[(Int, Iterable[Int])] = rdd.groupBy(x => x % 2)
    groupByRDD.collect().foreach(println)


  }
}
