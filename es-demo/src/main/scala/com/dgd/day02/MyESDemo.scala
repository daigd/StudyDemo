package com.dgd.day02

import java.util

import io.searchbox.client.config.HttpClientConfig
import io.searchbox.client.{JestClient, JestClientFactory}
import io.searchbox.core.{Index, Search, SearchResult}

/**
 * @author : DaiGD
 * @createtime :  2021年02月25日 16:31
 * @description : 
 */
object MyESDemo {
  
    private var factory:JestClientFactory = null

  def build():Unit = {
    factory = new JestClientFactory
    val config: HttpClientConfig = new HttpClientConfig.Builder("http://bigdata101:9200")
      .multiThreaded(true)
      .maxTotalConnection(20)
      .connTimeout(10 * 1000)
      .readTimeout(1000).build()
    
    factory.setHttpClientConfig(config)
  }

  def getClient():JestClient={
      if(factory==null) {
        build()
      }
      factory.getObject
    }
  
  def putIndex(movie: Movie,id:String):Unit = {
    val index: Index = new Index.Builder(movie)
      .index("movie-0225")
      .`type`("movie")
      .id(id)
      .build()
    
    // 获取client
    val client: JestClient = getClient()
    
    client.execute(index)
    client.close()
  }
  
  def queryIndex(query:String):Unit={
    val search: Search = new
        Search.Builder(query).addIndex("movie-0225").addType("movie").build()

    val client: JestClient = getClient()
    
    val result: SearchResult = client.execute(search)

    val hits: util.List[SearchResult#Hit[util.Map[String, Any], Void]] = result.getHits(classOf[util.Map[String, Any]])
    
    import scala.collection.JavaConverters._

    val list: List[util.Map[String, Any]] = hits.asScala.map(_.source).toList
    if(list.isEmpty){
      println("查询不到结果")
    }else{
      println(list.mkString("\n"))
    }
    
    client.close()
  }

  case class Movie(id:String,name:String,actorNameList:java.util.ArrayList[String])

  def main(args: Array[String]): Unit = {
    testQueryIndex
  }
  
  def testPutIndex(): Unit ={
    val actorNameList = new util.ArrayList[String]()
    actorNameList.add("沈腾")
    putIndex(Movie("2","夏洛特烦恼",actorNameList),"2")

    actorNameList.clear()
    actorNameList.add("周星驰")
    actorNameList.add("吴孟达")

    putIndex(Movie("3","七品芝麻官",actorNameList),"300")
  }
  
  def testQueryIndex:Unit={
    val query :String =
      """
        |{
        |   "query": {
        |     "match": {
        |       "actorNameList.keyword": "吴孟达"
        |     }
        |   }
        | }
        |""".stripMargin
    queryIndex(query)
  }
}
