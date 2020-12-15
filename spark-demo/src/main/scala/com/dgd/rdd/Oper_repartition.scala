package com.dgd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_repartition {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)

    val rdd: RDD[Int] = sc.makeRDD(Array(1, 2, 3, 4, 5), 3)

    // glom 作用:将一个分区的数据放到一个数组中
    println("重分区前:" + rdd.getNumPartitions)
    val glomRDD: RDD[Array[Int]] = rdd.glom()
    glomRDD.collect().foreach(array =>{
      println(array.mkString(","))
    })
    println("==========================")

    // repartition 重新分区
    // repartition 和 coalesce 区别：
    // 1.repartition 底层也是调用的 coalesce 方法,指定 shuffle 操作
    // 2.coalesce 合并分区,默认不进行 shuffle 操作
    val repartitionRdd: RDD[Int] = rdd.repartition(2)
    println("重分区后:" + repartitionRdd.getNumPartitions)
    repartitionRdd.glom().collect().foreach(array=>println(array.mkString(",")))

  }
}
