package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object MakeRDD {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    // 1,通过内存方式创建 RDD
    // 1.1 keRDD(),默认创建 th.max(处理器核数,2)个分区,底层也是调用 parallelize 方法,优先使用
    val makeRDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
    makeRDD.collect().foreach(println)
    // 1.2 parallelize() 并行方式创建 RDD
    val parallelizeRDD: RDD[Int] = sc.parallelize(List(1, 2, 3, 4))
    parallelizeRDD.collect().foreach(println)

    // 2,通过外部文件方式创建 RDD
    val fileRDD: RDD[String] = sc.textFile("input")
    fileRDD.collect().foreach(println)
    fileRDD.saveAsTextFile("output")

  }
}
