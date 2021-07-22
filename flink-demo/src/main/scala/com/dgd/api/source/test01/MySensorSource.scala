package com.dgd.api.source.test01

import java.util.concurrent.TimeUnit

import org.apache.flink.streaming.api.functions.source.SourceFunction

import scala.util.Random

/**
 * @description: 自定义数据源
 * @author DaiGD
 * @date 2021/3/19 19:21
 */
class MySensorSource extends SourceFunction[SensorReading]{

  var running = true
  override def run(ctx: SourceFunction.SourceContext[SensorReading]): Unit = {

    val random = new Random
    // 1,初始化一个温度值
    val curTemp = (1 to 10).map {
      id => ("sensor" + id, 65 + random.nextGaussian() * 20)
    }

    while (running) {
      // 2,模拟温度变化
      curTemp.map(t => (t._1, t._2 + random.nextGaussian() * 0.5))

      // 3,生成传感器数据
      curTemp.foreach(t=>ctx.collect(SensorReading(t._1,System.currentTimeMillis(),t._2)))

      // 4,延迟
      TimeUnit.SECONDS.sleep(1)
    }
  }

  override def cancel(): Unit = running = false
}
