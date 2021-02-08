package com.dgd.datastructure

import scala.io.StdIn

/**
 * @author : DaiGD
 * @createtime :  2021年01月28日 18:04
 * @description : 
 */
object SingleArrayQueue {
  def main(args: Array[String]): Unit = {
    // 初始化一个数组队列
    val array = new ArrayQueue(3)
    
    var key = ""
    while (true){
      
      println("show:显示队列")
      println("add:添加数据")
      println("exit:程序退出")
      
      key = StdIn.readLine()
      
      key match {
        case "show"=>array.show()
        case "add"=>
          println("请输入:")
          val i = StdIn.readInt()
          array.add(i)
        case "exit"=>
          println("程序退出")
          System.exit(0)
      }
    }
  }
}

class ArrayQueue(size:Int){
  val maxSize: Int = size
  val array = new Array[Int](size)
  var front: Int = -1
  var tail: Int = -1
  
  def isFull():Boolean={
    tail==maxSize-1
  }
  
  def isEmpty():Boolean={
    front==tail
  }
  
  def show():Unit={
    if(isEmpty()) {
      println("队列空空如也")
      return 
    }
    for(i<- front+1 to tail) {
      printf("Array[%d]=%d\n",i,array(i))
    }
  }
  
  def add(i:Int):Unit={
    if(isFull()) {
      println("队列已满")
      return 
    }
    tail += 1
    array(tail) = i
  }
}
