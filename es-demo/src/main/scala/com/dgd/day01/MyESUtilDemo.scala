package com.dgd.day01

import java.util

import io.searchbox.client.config.HttpClientConfig
import io.searchbox.client.{JestClient, JestClientFactory}
import io.searchbox.core.Index

/**
 * @author : DaiGD
 * @createtime :  2021年02月24日 10:56
 * @description : ES工具类
 */
object MyESUtilDemo {
  
  private var factory :JestClientFactory = null

  private def build():Unit = {
    factory = new JestClientFactory
    factory.setHttpClientConfig(
      new HttpClientConfig.Builder("http://bigdata101:9200")
        .multiThreaded(true)
        .maxTotalConnection(20)
        .connTimeout(10000)
        .readTimeout(1000).build())
  }

  private def getClient:JestClient={
    if(factory==null) {
      build()
    }
    factory.getObject
  }
  
  def putIndex1():Unit={
    val client: JestClient = getClient

    val source:String =
      """
        |{ "id":100,
        | "name":"红海行动",
        | "doubanScore":8.5,
        | "actorList":[ 
        |{"id":1,"name":"zhang yi"},
        |{"id":2,"name":"hai qing"},
        |{"id":3,"name":"zhang han yu"}
        |] }
        |""".stripMargin

    val index: Index = new
        Index.Builder(source)
      .id("1")
      .`type`("movie")
      .index("my_movie").build()
    
    client.execute(index)
    client.close()    
  }
  
  def putIndex2():Unit= {
    val client: JestClient = getClient
    
    val actorNameList = new util.ArrayList[String]()
    actorNameList.add("Zhang San")
    actorNameList.add("Li Si")
    actorNameList.add("Wang Wu")
    val index: Index = new Index.Builder(Movie("12", "zs", actorNameList))
      .`type`("movie")
      .index("my_movie2")
      .build()

    client.execute(index)

    client.close()
  }

  def main(args: Array[String]): Unit = {
//    putIndex1()
    putIndex2()
  }

}
