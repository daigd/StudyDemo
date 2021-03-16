package com.dgd.wc

import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala._

/**
 * @description: 读取socket流数据
 * @author DaiGD
 * @date 2021/3/16 13:57
 */
object WordCount02 {
  def main(args: Array[String]): Unit = {
    // 1,初始化执行环境
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    // 2,从命令行中获取执行参数
    val tool: ParameterTool = ParameterTool.fromArgs(args)
    val host: String = tool.get("host")
    val port: String = tool.get("port")
    assert(host!=null && !host.isEmpty, "host cannot be null!")
    assert(port != null && !port.isEmpty, "host cannot be null!")

    val inputStream: DataStream[String] = env.socketTextStream(host, port.toInt)

    val rs: DataStream[(String, Int)] = inputStream.flatMap(_.split(" ")).map((_, 1)).keyBy(0).sum(1)

    rs.print().setParallelism(1)

    env.execute()
  }
}
