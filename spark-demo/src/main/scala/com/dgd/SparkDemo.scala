package com.dgd

import org.apache.spark.sql.SparkSession

/**
 * @author : DaiGD
 * @createtime :  2020年12月11日 17:49
 * @description :
 */
object SparkDemo {
  def main(args: Array[String]): Unit = {
    //    val textPath = "test.txt" // 本地文件路径
    // 通过命令行参数指定文件路径
    if (args.isEmpty || args(0).isEmpty) {
      throw new Exception("File path cannot be null!")
    }
    val textPath = args(0)
    // 如果使用yarn模式,"spark.master"对应的值应换成 "yarn"
    val spark = SparkSession.builder().appName("app").config("spark.master", "yarn")
      .getOrCreate()
    val textFile = spark.read.textFile(textPath)
    val numA = textFile.filter(_.contains("a")).count()
    val numSpark = textFile.filter(_.contains("Spark")).count()
    println(s"Lines contains a: $numA, Lines ontains Spark: $numSpark")
    spark.stop()
  }
}
