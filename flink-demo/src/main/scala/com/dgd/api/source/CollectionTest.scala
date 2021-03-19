package com.dgd.api.source

import org.apache.flink.streaming.api.scala._

/**
 * @description: 集合测试
 * @author DaiGD
 * @date 2021/3/16 19:40
 */
object CollectionTest {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val rs: DataStream[Int] = env.fromCollection(List(1, 2, 3, 4))
    rs.print().setParallelism(1)

    env.execute
  }
}
