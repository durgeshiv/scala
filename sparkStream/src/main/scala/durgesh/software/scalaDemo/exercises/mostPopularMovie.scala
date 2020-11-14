package durgesh.software.scalaDemo.exercises

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{desc, lit}

object mostPopularMovie extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark   = SparkSession.builder()
    .appName("Popular Movie")
    .master("local[*]")
    .getOrCreate()

  val data = spark.read.option("delimiter", "\t").csv("file:///C:\\Users\\Durgesh Agnihotri\\Documents\\GitHub\\scala\\sparkStream\\src\\main\\resources\\u.data")
  val schString = "user_id,movie_id,rating,timestamp"
  val inDF = data.toDF(schString.split(","): _*).withColumn("count", lit(1))
  inDF.show()
  val df2 = inDF.groupBy("movie_id").sum("count")
  df2.withColumn("Movie Views", df2.col("sum(count)") ).select("movie_id", "Movie Views").orderBy(desc("Movie Views")).show()

  println(" movie names")
  val nameDF = spark.read.option("delimiter", "\\|").csv("file:///C:\\Users\\Durgesh Agnihotri\\Documents\\GitHub\\scala\\sparkStream\\src\\main\\resources\\u.item")
  println(" Doing same via RDD")
  val inpFile = spark.sparkContext.textFile("file:///C:\\Users\\Durgesh Agnihotri\\Documents\\GitHub\\scala\\sparkStream\\src\\main\\resources\\u.data")
   def parselines(line : String ) = {
     val fields = line.split("\t")
     val movie_id = fields(1).toInt
     movie_id
   }
  val parsedRDD = inpFile.map(parselines)
  val rdK = parsedRDD.map(x => (x,1)).reduceByKey((x,y) => (x+y)).map(x=> (x._2, x._1)).sortByKey()

  for ( elem <- rdK) {
    val movieName = elem._2
    val movieViews = elem._1
    println(s"Movie Name :: + ${movieName}, movieViews :: + $movieViews")
  }


}
