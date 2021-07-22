package com.dgd.api.transform.test02

import org.apache.flink.streaming.api.scala._

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/7/22 11:15
 */
object BaseTest {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)

    val input: DataStream[String] = env.readTextFile("src\\main\\resources\\sensor")

    val mapDS: DataStream[Int] = input.map(i => i.length)
    val flatMapDS: DataStream[String] = input.flatMap(i => i.split(","))
    val filterDS: DataStream[String] = input.filter(i => i.startsWith("sensor_1"))

    mapDS.print("map")
    flatMapDS.print("flatMap")
    filterDS.print("filter")

    env.execute("base transform test")

  }

}
