package com.dgd.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author : DaiGD
 * @createtime :  2020年12月23日 17:44
 * @description : 
 */
object RunningSqlDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("spark-sql")
    val spark = SparkSession.builder().config(conf).getOrCreate()
  
    import spark.implicits._

    val df = spark.read.json("src/main/resources/person.json")
    
    df.createOrReplaceTempView("person")

    val sqlDf = spark.sql(
      """
        |SELECT * FROM person
        |""".stripMargin)
    sqlDf.show()
    // +---------+---+---+-----+
    //|  address|age| id| name|
    //+---------+---+---+-----+
    //|  Beijing| 24|  1| 小王|
    //| Shanghai| 22|  2|Marry|
    //|Guangzhou| 30|  3| 老马|
    //+---------+---+---+-----+
    val sqlDf2 = spark.sql(
      """
        |SELECT name,count(*) from person
        |WHERE age > 22
        |AND address != 'Beijing'
        |GROUP BY name
        |""".stripMargin)
    sqlDf2.show()
    
    printf("=================%s====================\n","global temp view")
    // 创建全局视图
    df.createOrReplaceGlobalTempView("p")
    
    spark.sql("select * from global_temp.p").show()
    // +---------+---+---+-----+
    //|  address|age| id| name|
    //+---------+---+---+-----+
    //|  Beijing| 24|  1| 小王|
    //| Shanghai| 22|  2|Marry|
    //|Guangzhou| 30|  3| 老马|
    //+---------+---+---+-----+
    spark.newSession().sql("select * from global_temp.p").show()
    
    spark.stop()
    
  }
}
