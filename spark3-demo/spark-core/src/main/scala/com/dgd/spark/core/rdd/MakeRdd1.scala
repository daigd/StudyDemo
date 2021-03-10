package com.dgd.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author : DaiGD
 * @createtime :  2021年03月04日 14:48
 * @description : 
 */
object MakeRdd1 {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("rdd"))

    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
    
    rdd.saveAsTextFile("output")
    
    sc.stop()
    
  }

}
