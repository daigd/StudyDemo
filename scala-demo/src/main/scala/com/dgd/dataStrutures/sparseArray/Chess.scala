package com.dgd.dataStrutures.sparseArray

/**
 * @author : DaiGD
 * @createtime :  2020年12月31日 17:39
 * @description : 
 */
case class Chess(r: Int, c: Int, v: Int) {
  val row: Int = r
  val col: Int = c
  val value: Int = v

  override def toString: String = {
    row + "," + col + "," + value
  }
}

