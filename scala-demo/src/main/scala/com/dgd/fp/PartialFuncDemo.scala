package com.dgd.fp

/**
 * @author : DaiGD
 * @createtime :  2020年12月29日 11:16
 * @description : 偏函数 : filter + map 的结合体
 */
object PartialFuncDemo {
  def main(args: Array[String]): Unit = {
    val list = List("1", 2, 3, 3.4, "Hello")

    // 偏函数适用场景：
    // 需要结合使用 filter + map 函数的情况
    // 原生形式：
    val pf = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = {
        x.isInstanceOf[Int]
      }

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int] + 1
      }
    }

    println("原生使用偏函数,返回结果：" + list.collect(pf))

    // 简写方式一：用 case 语句来简写
    val pf2: PartialFunction[Any, Int] = {
      case i: Int => i + 1
      case d: Double => d.toInt + 3
    }

    println("使用case语句简写偏函数,返回结果:" + list.collect(pf2))

    // 简写方式二：代码块形式直接写在函数名后面
    val list2 = list.collect {
      case i: Int => i + 1
      case d: Double => d.toInt + 6
    }
    println("使用代码块+case语句简写偏函数,返回结果:" + list2)

  }
}
