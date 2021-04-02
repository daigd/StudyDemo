package com.dgd.stock

import java.time.LocalDateTime

/**
 * @description: 股票价格交易
 * @author DaiGD
 * @date 2021/3/30 9:28
 */
// 股票代号, 交易时间, 价格, 交易量
case class StockPrice(symbol:String,dateTime: LocalDateTime,price:Double,num:Int)
