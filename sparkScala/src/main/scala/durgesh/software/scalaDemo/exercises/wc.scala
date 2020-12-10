package durgesh.software.scalaDemo.exercises

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext._
object wc {
  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder()
      .appName("wc")
      .master("local[*]")
      .getOrCreate()

    val rdd = spark.sparkContext.textFile("file:///C:\\Users\\Durgesh Agnihotri\\Documents\\GitHub\\scala\\sparkStream\\src\\main\\resources\\wcinput.csv")
    val mp = rdd.flatMap(x => x.split(" ")).map(x => (x,1)).reduceByKey( (x,y) => (x + y))
    mp.foreach(println)

    println()

    println("wc using countbyValue")
    rdd.flatMap(x => x.split(" ")).countByValue().foreach(println)

  }

}
