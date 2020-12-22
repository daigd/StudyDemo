package com.dgd.spark.core.accumulator

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object Oper_accumulator {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5))
    // 声明累加器
    val sum: LongAccumulator = sc.longAccumulator("sum")

    rdd.foreach{
      case (num)=>
        sum.add(num)
    }

    println("累加后的值:" + sum.value)
  }
}
