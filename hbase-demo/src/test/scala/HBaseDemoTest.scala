import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.{HBaseConfiguration, HColumnDescriptor, HTableDescriptor, TableName}
import org.apache.hadoop.hbase.client.{Admin, ConnectionFactory, Get, HTable, Put}
import org.apache.hadoop.hbase.util.Bytes
import org.scalatest.{BeforeAndAfter, GivenWhenThen}
import org.scalatest.funsuite.AnyFunSuite

/**
 * @author : DaiGD
 * @createtime :  2020年12月08日 10:46
 * @description : HBase Demo验证
 */
class HBaseDemoTest extends AnyFunSuite with GivenWhenThen with BeforeAndAfter{

  val TABLE_NAME :String = "test"
  val conf: Configuration = HBaseConfiguration.create
  
  //before(init())
  def getAdmin(): Admin ={
    conf.set("hbase.zookeeper.quorum", "bigdata-01.com")
    val conn = ConnectionFactory.createConnection(conf)
    conn.getAdmin
  }
  
  test("HBase test") {
    val admin = getAdmin()
    // list the tables
    val listTables=admin.listTables()
    listTables.foreach(println)

    // let's insert some data in 'test' and get the row
    Given("insert some data in 'test'")
    val table = new HTable(conf, TABLE_NAME)
    val put = new Put(Bytes.toBytes("001"))

    // family: Array[Byte], qualifier: Array[Byte], value: Array[Byte]
    put.add(Bytes.toBytes("info"),Bytes.toBytes("nickName"), Bytes.toBytes("Jack"))
    table.put(put)

    Given("get the row")
    val get= new Get(Bytes.toBytes("001"))
    get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("nickName"))
    val result=table.get(get)
    val value=result.value()
    println(Bytes.toString(value))
    assert(Bytes.toString(value) == "Jack")
  }
  
  test("HBase 创建表") {
    Given("实例化Admin")
    val admin = getAdmin()
    
    Given("创建TableDescriptor")
    
    val table = new HTableDescriptor(TableName.valueOf("demo"))
    val family = new HColumnDescriptor(Bytes.toBytes("info"))
    table.addFamily(family)
    
    Given("创建表")
    admin.createTable(table)
    
  }
  
  test("禁用表"){
    Given("判断是否被禁用")
    val admin = getAdmin()
    val tableName = TableName.valueOf("demo")
    var isDisabled = admin.isTableDisabled(tableName)
    if(!isDisabled) {
      admin.disableTable(tableName)
      isDisabled = admin.isTableDisabled(tableName)
    }
    assert(isDisabled)
  }
  
  test("启用表"){
    val admin = getAdmin()
    val tableName = TableName.valueOf("demo")
    var isDisabled = admin.isTableDisabled(tableName)
    if(isDisabled){
      admin.enableTable(tableName)
      isDisabled = admin.isTableDisabled(tableName)
    }
    assert(!isDisabled)
  }
}
