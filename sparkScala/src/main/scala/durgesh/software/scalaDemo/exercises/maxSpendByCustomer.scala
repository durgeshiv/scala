package durgesh.software.scalaDemo.exercises

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession


object maxSpendByCustomer extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)
  println("Solving using DF approach")
  val spark =  SparkSession.builder().
    appName("min temp")
    .master("local[*]")
    .getOrCreate()
  val inDF = spark.read.csv("file:///C:\\Users\\Durgesh Agnihotri\\Documents\\GitHub\\scala\\sparkStream\\src\\main\\resources\\customer-orders.csv")
  val schString = "customerID,orderId,amount"

  val prDF = inDF.toDF(schString.split(","): _*)
  val cstDF = prDF.withColumn("amount", prDF.col("amount").cast("Double"))

  val maxspendDF = cstDF.groupBy("customerID")
    .sum("amount").as("amount_spend")
    .select( "customerID", "sum(amount)")
    .show()



  println(" by RDD fashion")

  def parelines(line : String) = {
    val fields = line.split(",")
    val customerID = fields(0).toInt
    val amount = fields(2).toDouble
    (customerID, amount)
  }

  val fle = spark.sparkContext.textFile("file:///C:\\Users\\Durgesh Agnihotri\\Documents\\GitHub\\scala\\sparkStream\\src\\main\\resources\\customer-orders.csv")

  val parsedRDD = fle.map(parelines)
  val result = parsedRDD.reduceByKey( (x,y) => (x+y) ).collect()
  for (elem <- result) {
    println(s" customer :: ${elem._1}, total amount :: ${elem._2}")
  }

}
