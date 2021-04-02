package com.dgd.stock

import org.apache.flink.streaming.api.functions.source.SourceFunction

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/4/1 9:25
 */
class StockSource extends SourceFunction[StockPrice]{
  override def run(sourceContext: SourceFunction.SourceContext[StockPrice]): Unit = ???

  override def cancel(): Unit = ???
}
