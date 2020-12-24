package com.dgd.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author : DaiGD
 * @createtime :  2020年12月24日 10:08
 * @description : 
 */
object DataSetsDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark-sql-dataset")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    import spark.implicits._

    // 如果不声明 spark.implicits._ , 找不到toDS方法
    val ds = Seq(People(1L, "Andy", 32, "GZ")).toDS
    ds.show()
    // +----+---+
    //|name|age|
    //+----+---+
    //|Andy| 32|
    //+----+---+

    val peopleDS = spark.read.json("src/main/resources/person.json").as[People]
    peopleDS.show()
    // +---------+---+---+-----+
    //|  address|age| id| name|
    //+---------+---+---+-----+
    //|  Beijing| 24|  1| 小王|
    //| Shanghai| 22|  2|Marry|
    //|Guangzhou| 30|  3| 老马|
    //+---------+---+---+-----+
    spark.stop()
  }

  case class People(id: Long, name: String, age: BigInt, address: String)

}
