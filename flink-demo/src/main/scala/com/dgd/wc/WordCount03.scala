package com.dgd.wc

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/6/21 19:51
 */
object WordCount03 {
  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val inputPath = "src\\main\\resources\\hello.txt"
    val ds: DataSet[String] = env.readTextFile(inputPath)
    val result: AggregateDataSet[(String, Int)] = ds.flatMap(_.split(" ")).map((_, 1)).groupBy(0).sum(1)

    result.print()
  }
}
