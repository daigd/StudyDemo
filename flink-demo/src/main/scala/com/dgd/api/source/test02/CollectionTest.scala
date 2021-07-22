package com.dgd.api.source.test02

import org.apache.flink.streaming.api.scala._

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/7/19 11:43
 */
object CollectionTest {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    // 设置并行度为1,使得全部任务抢占同一个线程执行
    env.setParallelism(1)

    val ds: DataStream[SensorReading] = env.fromCollection(List(SensorReading("sensor_1", 1547718199L, 35.8),
      SensorReading("sensor_6", 1547718201L, 15.4),
      SensorReading("sensor_7", 1547718202L, 6.7)))
    ds.print("Sensor")

    val intStream: DataStream[Int] = env.fromCollection(List(1, 2, 34, 53, 5))
    intStream.print("Int")

    env.execute("sourceTest_collection")

  }
}
