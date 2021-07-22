package com.dgd.api.source.test01

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

/**
 * @description: Kafka 数据源
 * @author DaiGD
 * @date 2021/3/16 19:47
 */
object KafkaTest {

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val props: Properties = new Properties()
    props.setProperty("bootstrap.servers","bigdata-dev01:9092")
    props.setProperty("group.id","consumer-group")
    props.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    props.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    props.setProperty("auto.offset.reset","latest")

    val input: DataStream[String] = env.addSource(new FlinkKafkaConsumer[String]("sensor", new SimpleStringSchema(), props))

    input.print().setParallelism(1)

    env.execute("kafka test")
  }
}
