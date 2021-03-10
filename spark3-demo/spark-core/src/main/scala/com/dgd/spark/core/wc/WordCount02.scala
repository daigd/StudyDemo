package com.dgd.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author : DaiGD
 * @createtime :  2021年03月04日 10:23
 * @description : 
 */
object WordCount02 {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("wc"))

    val file: RDD[String] = sc.textFile("input/word.txt")

    val groupRDD: RDD[(String, Iterable[String])] = file.flatMap(_.split(" ")).groupBy(word => word)

    groupRDD.map{
      case (k,iter)=>
        (k,iter.size)
    }.collect().foreach(println)
    sc.stop()
  }
}
