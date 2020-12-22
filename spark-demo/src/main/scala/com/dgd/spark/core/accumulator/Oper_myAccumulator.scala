package com.dgd.spark.core.accumulator

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import java.util
import scala.collection.mutable


object Oper_myAccumulator {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("rd")
    val sc: SparkContext = new SparkContext(conf)
    // 自定义累加器
    val mySum = new MyAccumulator
    sc.register(mySum, "mySum")

    val rdd: RDD[String] = sc.makeRDD(List("A", "B", "C", "A", "B", "D"))
    rdd.foreach(x => mySum.add(x))

    println("字母统计值:" + mySum.value)
  }

  // 自定义累加器
  // 1.继承 AccumulatorV2
  // 2.重写方法
  class MyAccumulator extends AccumulatorV2[String, java.util.List[String]] {
    val list: util.ArrayList[String] = new util.ArrayList[String]()

    override def isZero: Boolean = list.isEmpty

    override def copy(): AccumulatorV2[String, util.List[String]] = new MyAccumulator

    override def reset(): Unit = {
      list.clear()
    }

    override def add(v: String): Unit = {
      list.add(v)
    }

    override def merge(other: AccumulatorV2[String, util.List[String]]): Unit = {
      list.addAll(other.value)
    }

    override def value: util.List[String] = list
  }

}
