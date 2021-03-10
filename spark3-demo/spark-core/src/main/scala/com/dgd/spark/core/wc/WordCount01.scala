package com.dgd.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author : DaiGD
 * @createtime :  2021年03月04日 10:03
 * @description : 
 */
object WordCount01 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("wc")
    val sc = new SparkContext(conf)

    val file: RDD[String] = sc.textFile("input/word.txt")
    
    file.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)
    
    sc.stop()
  }
}
