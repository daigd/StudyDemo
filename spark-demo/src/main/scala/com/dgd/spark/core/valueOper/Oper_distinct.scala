package com.dgd.spark.core.valueOper

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_distinct {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 3, 2, 1, 3, 4, 5))
    // distinct 算子：对数据进行去重,也会对数据进行打乱重组
    rdd.saveAsTextFile("in1")
    val distinctRDD: RDD[Int] = rdd.distinct()
    distinctRDD.saveAsTextFile("out1")
    distinctRDD.foreach(println)


  }
}
