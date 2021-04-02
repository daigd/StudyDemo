package com.dgd.wc

import org.apache.flink.api.scala._

/**
 * @author DaiGD
 * @date 2021/3/16 9:23
 */
object WordCount01 {
  def main(args: Array[String]): Unit = {
    // 1,执行环境
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val input: DataSet[String] = env.readTextFile("input")
    val flatMap: DataSet[String] = input.flatMap(_.split(" "))
    val result: AggregateDataSet[(String, Int)] = flatMap.map((_, 1)).groupBy(0).sum(1)
    result.print()
  }
}
