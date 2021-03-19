package com.dgd.api.source

import org.apache.flink.streaming.api.scala._

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/3/19 19:44
 */
object MySource {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val input: DataStream[SensorReading] = env.addSource(new MySensorSource)

    input.print().setParallelism(1)

    env.execute("MySource Test")
  }
}
