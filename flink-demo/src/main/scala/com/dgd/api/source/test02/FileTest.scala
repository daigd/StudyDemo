package com.dgd.api.source.test02

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/7/19 11:54
 */
object FileTest {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)

    val ds: DataStream[String] = env.readTextFile("src\\main\\resources\\sensor")
    ds.print()

    env.execute()
  }
}
