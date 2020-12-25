package com.dgd.exercise

import scala.reflect.internal.util.StringOps

object Demo01 {
  def main(args: Array[String]): Unit = {
    println(signum(8))
    // 一个空的块值是什么？类型是什么
    val blank_block = {}
    println(blank_block)
    println("=============for2Scala=============")
    for2Scala()
    println("=============for2Scala2=============")
    for2Scala2(5)
    println("=============for2Scala3=============")
    for2Scala3(5)
    println("=============for2Scala4=============")
    for2Scala4(5)
    println("=============countdown=============")
    countdown(10)
    println("=============calLetterUnicode=============")
    println("Hello的乘积:" + calLetterUnicode("Hello"))
    println("=============calLetterUnicodeByStringOps=============")
    println("Hello的乘积:" + calLetterUnicodeByStringOps("Hello"))
    println("=============calLetterUnicode2=============")
    println("Hello的乘积2:" + calLetterUnicode2("Hello"))

  }

  def signum(n: Int): Int = {
    if (n > 0) {
      1
    } else if (n < 0) {
      -1
    } else {
      0
    }
  }

  def for2Scala(): Unit = {
    // for(int i=10;i>=0;i--){System.out.println(i);} 换成 scala 版本
    var i = 10
    while (i >= 0) {
      println(i)
      i -= 1
    }
  }

  def for2Scala2(n: Int): Unit = {
    println(n)
    if (n != 0) {
      for2Scala2(n - 1)
    }
  }

  def for2Scala3(n: Int): Unit = {
    for (i <- 0 to n reverse) {
      println(i)
    }
  }

  def for2Scala4(n: Int): Unit = {
    (0 to n).reverse.foreach(println)
  }

  // 编写一个countdown(n:Int)过程,打印从n到0的过程
  def countdown(n: Int): Unit = {
    println(n)
    if (n != 0) {
      countdown(n - 1)
    }
  }

  // 计算字符串所有字母的Unicode(toLong方法)编码的乘积,如Hello的乘积为:9415087488L
  def calLetterUnicode(s: String): Long = {
    var sum: Long = 1L
//    val array: Array[Char] = s.toCharArray
//    for (c <- array) {
//      sum *= c.toLong
//    }
    // 更好的方式
    for(c<-s){
      sum *= c.toLong
    }
    sum
  }


  // 用StringOps的foreach方法来解决上面的问题
  def calLetterUnicodeByStringOps(s: String): Long = {
    var res = 1L
    s.foreach(res *= _.toLong)
    res
  }

  // 计算字母unicode乘积改成递归方式实现
  def calLetterUnicode2(s: String): Long = {
    if (s.length == 1) {
      s.charAt(0).toLong
    } else {
      //calLetterUnicode2(s.charAt(0).toString) * calLetterUnicode2(s.substring(1))
      calLetterUnicode2(s.take(1)) * calLetterUnicode2(s.drop(1))
    }
  }

}
