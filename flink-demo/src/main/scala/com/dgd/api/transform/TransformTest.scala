package com.dgd.api.transform

import com.dgd.api.source.SensorReading
import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.streaming.api.scala._

/**
 * @description: 转换算子API测试
 * @author DaiGD
 * @date 2021/3/22 18:55
 */
object TransformTest {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val inputs: DataStream[String] = env.readTextFile("input/sensor.txt")

    val sensor: DataStream[SensorReading] = inputs.map(line =>{
      val temp = line.split(",")
      SensorReading(temp(0), temp(1).toLong, temp(2).toDouble)
    })
//    val filterStream: DataStream[(String, Int)] = mapStream.filter(_._1.startsWith("h"))
//    filterStream.print().setParallelism(1)

    val keyByStream: KeyedStream[SensorReading, Tuple] = sensor.keyBy("timestamp")

//    keyByStream.sum(1).print().setParallelism(1)
//    keyByStream.min("temperature").print().setParallelism(1)
    keyByStream.minBy("temperature").print().setParallelism(1)


    env.execute("transform api test")

  }
}
