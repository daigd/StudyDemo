package com.dgd.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author : DaiGD
 * @createtime :  2020年12月24日 11:24
 * @description : RDD <<=>> DF <<=>> DS 相互转换
 */
object InterOperatingDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("spark-sql-interOperation").setMaster("local[*]")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    import spark.implicits._

    val df = spark.sparkContext.textFile("src/main/resources/salary.txt")
      .map(_.split(","))
      .map(line => People(line(0), line(1).trim.toLong))
      .toDF()
    df.show()

    df.createOrReplaceTempView("people")
    // +----+------+
    //|name|salary|
    //+----+------+
    //|小马|  2000|
    //|Jack|  1500|
    //|小钱| 25000|
    //| Tom|  4500|
    //+----+------+

    val peopleDf = spark.sql("select name,salary from people where salary > 4000")
    peopleDf.show()
    // +----+------+
    //|name|salary|
    //+----+------+
    //|小钱| 25000|
    //| Tom|  4500|
    //+----+------+
    peopleDf.map(r => "Name:" + r.getAs[String]("name")).show()
    // +---------+
    //|    value|
    //+---------+
    //|Name:小钱|
    //| Name:Tom|
    //+---------+
    val ds = df.as[People]
    ds.select("name").show()
    // +----+
    //|name|
    //+----+
    //|小马|
    //|Jack|
    //|小钱|
    //| Tom|
    //+----+
    val df2 = ds.toDF()
    df2.show()
    // +----+------+
    //|name|salary|
    //+----+------+
    //|小马|  2000|
    //|Jack|  1500|
    //|小钱| 25000|
    //| Tom|  4500|
    //+----+------+
    val rdd = df2.toJavaRDD.rdd
    rdd.collect().foreach(println)
    // [小马,2000]
    //[Jack,1500]
    //[小钱,25000]
    //[Tom,4500]
    
    spark.stop()

  }

  case class People(name: String, salary: Long)

}
