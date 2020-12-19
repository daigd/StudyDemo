package com.dgd.spark.core.keyValueOper

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Oper_join {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 10), ("b", 10), ("c", 14)))
    val rdd2: RDD[(String, Int)] = sc.makeRDD(List(("a", 40), ("b", 20), ("c", 24)))

    // join 算子: 对相同key的数据进行关联
    rdd.join(rdd2).collect().foreach(println)
    println("=====================================")
    // key 不相等时,会将多余的key数据丢弃
    val rdd3: RDD[(String, Int)] = sc.makeRDD(List(("a", 60), ("b", 50)))

    rdd.join(rdd3).collect().foreach(println)
  }
}
