package durgesh.software.scalaDemo.exercises

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import scala.math._

object mintemp extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder().
    appName("min temp")
    .master("local[*]")
    .getOrCreate()

  println("Solving using DF")

  val inDF = spark.read.option("inferSchema", "true").csv("file:///C:\\Users\\Durgesh Agnihotri\\Documents\\GitHub\\scala\\sparkStream\\src\\main\\resources\\1800.csv")

  val colsString = "stationID,areaID,entryType,temp,a,b,c,d"

  val schDF = inDF.toDF(colsString.split(",") : _*)
  schDF.printSchema()
  import spark.implicits._
  schDF.filter(schDF.col("entryType") === "TMIN" ).groupBy("stationID").min("temp")/*.select($"stationID", $"temp")*/.show()

  println("solving using RDD")

  val rdd = spark.sparkContext.textFile("file:///C:\\Users\\Durgesh Agnihotri\\Documents\\GitHub\\scala\\sparkStream\\src\\main\\resources\\1800.csv", 8)
  println("rdd partitions :: " + rdd.partitions.mkString("-"))
  println(rdd.getNumPartitions)
  def parselines(lines: String) = {
    val fields = lines.split(",")
    val stationID = fields(0)
    val entryType = fields(2)
    val temp = fields(3).toInt
    (stationID, entryType,temp)
  }

  val parsedLines = rdd.map(parselines).filter(x=> x._2 == "TMIN")
  // taking out stationType and temp
  val filteredRDD = parsedLines.map(x => (x._1, x._3))
  filteredRDD.reduceByKey((x,y) => min(x,y)).foreach(println)

  println(filteredRDD.dependencies.mkString)




}
