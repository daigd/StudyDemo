package com.dgd.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author : DaiGD
 * @createtime :  2020年12月23日 17:27
 * @description : 
 */
object SparkSqlDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("spark-sql").setMaster("local[*]")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    // 声明隐式转换
    import spark.implicits._

    val df = spark.read.json("src/main/resources/person.json")
    df.show()
    // +---------+---+---+-----+
    //|  address|age| id| name|
    //+---------+---+---+-----+
    //|  Beijing| 24|  1| 小王|
    //| Shanghai| 22|  2|Marry|
    //|Guangzhou| 30|  3| 老马|
    //+---------+---+---+-----+
    df.printSchema()
    // root
    // |-- address: string (nullable = true)
    // |-- age: long (nullable = true)
    // |-- id: long (nullable = true)
    // |-- name: string (nullable = true)
    df.select($"name", $"age" + 1, $"address").show()
    // +-----+---------+---------+
    //| name|(age + 1)|  address|
    //+-----+---------+---------+
    //| 小王|       25|  Beijing|
    //|Marry|       23| Shanghai|
    //| 老马|       31|Guangzhou|
    //+-----+---------+---------+
    df.filter($"age" > 25).show()
    // +---------+---+---+----+
    //|  address|age| id|name|
    //+---------+---+---+----+
    //|Guangzhou| 30|  3|老马|
    //+---------+---+---+----+
    df.groupBy("age").count().show()
    // +---+-----+
    //|age|count|
    //+---+-----+
    //| 22|    1|
    //| 30|    1|
    //| 24|    1|
    //+---+-----+
    
    
  }
}
