package durgesh.software.scalaDemo.exercises

import org.apache.spark.sql.SparkSession

object creatingDF extends App {

  val spark = SparkSession.builder().appName("df creator").master("local[*]").getOrCreate()
  val data = Seq((1,"Durgesh","Capgemini"), (2,"Shreya", "Deloitte"))
  import spark.implicits._
  val rdd = spark.sparkContext.parallelize(data)
  val schString = "ID,Name,Company"
  val dataFr = rdd.toDF(schString.split(","): _*)

  println(" printing dataframe")
  dataFr.show()

  case class Employee(id: Int, name: String, company: String)
 // val dta = data.map(x=> List(Employee(x)))


}
