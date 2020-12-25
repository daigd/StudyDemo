package com.dgd.mybreak

import scala.util.control._


/**
 * @author : DaiGD
 * @createtime :  2020年12月25日 17:48
 * @description : 
 */
object BreakDemo {
  def main(args: Array[String]): Unit = {

    val loop = new Breaks
    loop.breakable {
      for (i <- 1 to 10) {
        println(i)
        if (i == 4) {
          loop.break()
        }
      }
    }
  }
}
