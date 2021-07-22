package com.dgd.api.source.test02

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/7/22 10:20
 */
object KafkaTest {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    // 设置属性
    val prop: Properties = new Properties()
    prop.setProperty("bootstrap.servers","bigdata101:9092")
    prop.setProperty("group.id","kafka-test")
    prop.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    prop.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    prop.setProperty("auto.offset.reset","latest")

    val kafkaDS: DataStream[String] = env.addSource(new FlinkKafkaConsumer[String]("sensor", new SimpleStringSchema(), prop))
    kafkaDS.print("kafka test")

    env.execute("kafka source test")

  }
}
