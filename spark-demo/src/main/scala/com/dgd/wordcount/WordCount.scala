package com.dgd.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("wordCount").setMaster("local")
    val sc: SparkContext = new SparkContext(config)
    // 读取文件
    val lines: RDD[String] = sc.textFile("test.txt")
    // 将一行一行的数据按空格拆分成一个一个的单词
    val words: RDD[String] = lines.flatMap(_.split(" "))
    // 结构转换,将每个单词转成key-value的形式:单词为key,键统一为1
    val wordToOne: RDD[(String, Int)] = words.map((_, 1))
    // 以key来分组统计
    val wordToSum: RDD[(String, Int)] = wordToOne.reduceByKey(_ + _)
    // 最后结果输出
    val result: Array[(String, Int)] = wordToSum.collect()
    result.foreach(println)
    sc.stop()
  }

}
