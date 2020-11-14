package durgesh.software.scalaDemo.exercises

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.slf4j._
import org.apache.spark.sql.functions._

object dataframe_project_solution extends App {

  val spark  = SparkSession.builder()
    .master("local[*]")
    .appName("dataframe exercise - pierian data")
    .getOrCreate()


  log4j.Logger.getLogger("org").setLevel(Level.ERROR)
  val data = spark.read.option("inferSchema", "true").option("header","true").csv("src/main/resources/Netflix_2011_2016.csv")
  data.show(5, false)
  println(data.columns.toList)

  println("describing dataframes")
  data.describe()

  println("HV ratio")
  val df2 =  data.withColumn("HV Ratio", data.col("High")/(data.col("Volume")))

  df2.show()
/*

  println("Date when Peak of High")
  df2.max("High").show()

  Window.over

*/


}
