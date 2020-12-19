package com.dgd.spark.core.keyValueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_aggregateByKey {

  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("b", 1), ("c", 1), ("a", 1),("b", 3)),2)
//    rdd.saveAsTextFile("out1")
    // aggregateByKey 算子: 按照规则对数据进行分区内和分区间计算
    // 需求:取出分区内相同key的最大值,然后分区间相加
    // aggregateByKey 是函数柯里化,存在两个参数列表
    // 1,第一个参数表示初始值
    // 2,第二个参数列表有两个参数:
    // 2.1,第一个表示分区内的计算规则
    // 2.2,第二个表示分区间的计算规则
    val aggregateByKeyRDD: RDD[(String, Int)] = rdd.aggregateByKey(0)((x, y) => Math.max(x, y), (x, y) => x + y)
//    aggregateByKeyRDD.saveAsTextFile("out2")
    aggregateByKeyRDD.collect().foreach(println)
  }
}
