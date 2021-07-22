package com.dgd.api.transform.test02

import com.dgd.api.source.test02.SensorReading
import org.apache.flink.streaming.api.scala._

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/7/22 20:19
 */
object MaxByTest {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)

    val input: DataStream[String] = env.readTextFile("src\\main\\resources\\sensor")
    val sensorDS: DataStream[SensorReading] = input.map(line => {
      val fields: Array[String] = line.split(",")
      SensorReading(fields(0), fields(1).toLong, fields(2).toDouble)
    })

    val keyDS: KeyedStream[SensorReading, String] = sensorDS.keyBy(_.name)
    // maxBy 会将记录的其它字段也同步更新, max 只会更新比较的字段，其它字段不变
    val result: DataStream[SensorReading] = keyDS.maxBy("temperature")

    result.print("result")

    env.execute()
  }

}
