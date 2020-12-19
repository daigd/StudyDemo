package com.dgd.spark.core.valueOper

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Oper_sample {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("rdd").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5))
    // sample 算子：按指定策略对数据进行采样
    // 1.抽取数据不放回
    // withReplacement:false->伯努利算法
    // fraction:抽取几率,介于0,1之间,0->全不取,1->全部取
    // seed:随机数种子
    rdd.sample(false, 0.4, 3).foreach(println)
    println("============================================")
    // 2.抽取数据放回
    // withReplacement:true->泊松算法
    // fraction:重复数据的几率,大于等于0,表示每个元素被期望抽取到的次数
    // seed:随机数种子
    rdd.sample(true,1).foreach(println)


  }
}
