package durgesh.software.scalaDemo



object foldAndReduce extends App{

  val list = List(1,2,3)
    // for imperetive
  var sum = 0
  for (element <- list) {
    sum = sum + element
  }
  println("sum is :: " + sum)

  // doing same via functional way

  def add(X: Int, y: Int) =  X + y
  println("fold Right :: " + list.foldRight(0)(add))

  println("fold :: " + list.fold(0)(add))

/*
  val spark = SparkSession
    .builder()
    .appName("testApp")
    .master("local[1]")
    .getOrCreate()


  val data = List(("James","","Smith","1991-04-01","M",3000),
    ("Michael","Rose","","2000-05-19","M",4000),
    ("Robert","","Williams","1978-09-05","M",4000),

    ("Maria","Anne","Jones","1967-12-01","F",4000),
    ("Jen","Mary","Brown","1980-02-17","F",-1))

  val columns = List("firstname","middlename","lastname","dob","gender","salary")

*/



  /*val rdd = spark.sparkContext.parallelize(data.map(x => Row(x._1, x._2, x._3, x._4, x._5, x._6)))
  val schString = columns.map(x => StructField(x, types.StringType, false))
  val df = spark.createDataFrame(rdd, StructType(schString))
  df.show()
  */

/*

  import spark.implicits._
  val df = spark.sparkContext.parallelize(data).toDF(columns: _*).show()
*/




}
