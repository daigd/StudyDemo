package com.dgd.spark.streaming.wc

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author : DaiGD
 * @createtime :  2021年03月04日 17:29
 * @description : 
 */
object WordCount {
  def main(args: Array[String]): Unit = {

    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming-wordCount")
    val ssc = new StreamingContext(conf, Seconds(3))

    val lineStream: ReceiverInputDStream[String] = ssc.socketTextStream("bigdata101", 9988)

    val wordAndCountStream: DStream[(String, Int)] = lineStream.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)

    wordAndCountStream.print()
    
    ssc.start()
    ssc.awaitTermination()
    
  }
}
