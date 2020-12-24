package com.dgd.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoder, Encoders, Row, SparkSession}
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, IntegerType, LongType, StructField, StructType}

/**
 * @author : DaiGD
 * @createtime :  2020年12月24日 10:32
 * @description : User-Defined Aggregate Functions:用户自定义聚合函数
 */
object UDAFDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("spark-sql-udaf").setMaster("local[*]")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    import spark.implicits._

    // 需求:统计员工平均工资
    val df = spark.read.json("src/main/resources/salary.json")
    df.show()
    // +----+------+
    //|小马|  2000|
    //|Jack|  1500|
    //|小钱| 25000|
    //| Tom|  4500|
    //+----+------+

    spark.udf.register("myAverage", MyAverage)

    df.createOrReplaceTempView("s")

    spark.sql("select myAverage(salary) from s").show()
    // +------------------+
    //|myaverage$(salary)|
    //+------------------+
    //|            8250.0|
    //+------------------+

    val ds = df.as[Employee]
    val avgSalary = MyAverage2.toColumn.name("myAverage2")
    ds.select(avgSalary).show()
    // +----------+
    //|myAverage2|
    //+----------+
    //|    8250.0|
    //+----------+

    spark.stop()

  }

  case class Employee(name: String, salary: Long)

  case class Average(var sum: Long, var count: Long)

  // 类型安全的聚合函数
  object MyAverage2 extends Aggregator[Employee, Average, Double] {
    override def zero: Average = Average(0L, 0L)

    override def reduce(b: Average, a: Employee): Average = {
      b.sum += a.salary
      b.count += 1L
      b
    }

    override def merge(b1: Average, b2: Average): Average = {
      b1.sum += b2.sum
      b1.count += b2.count
      b1
    }

    override def finish(reduction: Average): Double = reduction.sum / reduction.count

    override def bufferEncoder: Encoder[Average] = Encoders.product

    override def outputEncoder: Encoder[Double] = Encoders.scalaDouble
  }

  // 不指定类型的聚合函数
  object MyAverage extends UserDefinedAggregateFunction {
    override def inputSchema: StructType = StructType(StructField("input", LongType) :: Nil)

    override def bufferSchema: StructType = {
      StructType(StructField("sum", LongType) :: StructField("count", LongType) :: Nil)
    }

    override def dataType: DataType = DoubleType

    override def deterministic: Boolean = true

    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer(0) = 0L
      buffer(1) = 0L
    }

    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      if (!input.isNullAt(0)) {
        buffer(0) = buffer.getLong(0) + input.getLong(0)
        buffer(1) = buffer.getLong(1) + 1L
      }
    }

    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
      buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
    }

    override def evaluate(buffer: Row): Double = buffer.getLong(0) / buffer.getLong(1)
  }

}
