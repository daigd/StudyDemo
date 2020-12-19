package com.dgd.spark.core.valueOper

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_sortBy {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 3, 2, 1, 3, 4, 5))
    // sortBy 算子:按指定规则排序,默认升序,排序前后分区数不变,会经历 shuffle 过程
    val sortByRDD1: Array[Int] = rdd.sortBy(x => x).collect()
    sortByRDD1.foreach(println)
    println("======================================")
    val sortByRDD2: Array[Int] = rdd.sortBy(x => x, false).collect()
    sortByRDD2.foreach(println)

  }

}
