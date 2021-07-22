package com.dgd.api.source.test02

import java.util.Random

import org.apache.flink.streaming.api.functions.source.SourceFunction
import org.apache.flink.streaming.api.scala._

import scala.collection.immutable

/**
 * @description: 自定义Source测试
 * @author DaiGD
 * @date 2021/7/22 10:31
 */
object UDFTest {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val ds: DataStream[SensorReading] = env.addSource(MySensorSource())

    ds.print().setParallelism(1)

    env.execute("udf source test")
  }


}

case class MySensorSource() extends SourceFunction[SensorReading]{

  // 定义标识位,标识数据是否正常运行
  var running:Boolean = true

  override def run(sourceContext: SourceFunction.SourceContext[SensorReading]): Unit = {
    // 定义随机数生成器
    val random: Random = new Random()

    // 初始化10个温度初始值
    var temperature: immutable.IndexedSeq[(String, Double)] = 1.to(10).map(i => ("sensor+" + i, 60 + random.nextGaussian() * 20))

    // 生成数据
    while(running) {
      // 1. 更新温度值
      temperature =temperature.map(t=>(t._1,t._2+random.nextGaussian()))

      // 2. 获取当前时间值,包装样例类
      val time: Long = System.currentTimeMillis()
      temperature.foreach(t=>sourceContext.collect(SensorReading(t._1,time,t._2)))

      Thread.sleep(200)
    }

  }

  override def cancel(): Unit = {
    running = false
  }
}
