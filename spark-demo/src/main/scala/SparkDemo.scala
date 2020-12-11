import org.apache.spark.sql.SparkSession

/**
 * @author : DaiGD
 * @createtime :  2020年12月11日 17:49
 * @description : 
 */
object SparkDemo {
  def main(args: Array[String]): Unit = {
    val textPath = "test.txt"
    val spark = SparkSession.builder().appName("app").config("spark.master", "local")
      .getOrCreate()
    val textFile = spark.read.textFile(textPath)
    val numAs = textFile.filter(line => line.contains("a")).count()
    val numBs = textFile.filter(line => line.contains("Spark")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
