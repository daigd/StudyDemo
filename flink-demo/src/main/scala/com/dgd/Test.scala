package com.dgd

/**
 * @description: TODO
 * @author DaiGD
 * @date 2021/4/14 11:17
 */
object Test {
  def main(args: Array[String]): Unit = {
    import java.text.SimpleDateFormat
    val sdf = new SimpleDateFormat("yyyy-MM-dd")
    val weekStr = "2020-04-14"
    val date = sdf.parse(weekStr)
    sdf.applyPattern("w")
    val week = weekStr.substring(0, 4) + "-" + sdf.format(date)
    System.out.println("根据给定日期获取第几周: " + week)

    // not_confirm
  }
}
