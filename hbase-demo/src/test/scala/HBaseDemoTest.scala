import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{ConnectionFactory, Get, HTable, Put}
import org.apache.hadoop.hbase.util.Bytes
import org.scalatest.GivenWhenThen
import org.scalatest.funsuite.AnyFunSuite

/**
 * @author : DaiGD
 * @createtime :  2020年12月08日 10:46
 * @description : HBase Demo验证
 */
class HBaseDemoTest extends AnyFunSuite with GivenWhenThen{

  val TABLE_NAME :String = "test"

  test("HBase test") {
    val conf = HBaseConfiguration.create
    conf.set("hbase.zookeeper.quorum", "bigdata-01.com")
    val conn = ConnectionFactory.createConnection(conf)
    val admin = conn.getAdmin

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
}
