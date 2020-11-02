package durgesh.software.scalaDemo.exercises


import java.io.{File, FileNotFoundException, PrintWriter}

import scala.io.Source
import scala.util.{Failure, Success, Try}

object FileHandlingObj extends App {

  //Reading from files
  //getClass.getResourceAsStream("movie_ratings.csv")

  //Reading and parsing file
  val data  =


  lazy val data = Source.fromResource("movie_ratings.csv")
    .getLines()
    .toList
    .tail

 /*println("lazy val data")
  data.map(println)
*/
  //Using fromFile

  /*val result = Try {
    val path = "src/main/resources/movie_ratings.csv"
    val file = Source.fromFile(path)
    val data2 = file.getLines().toList
    //println(data2)
    file.close()
    data2
  } match {
    case Success(value) => Right(value)
    case Failure(exception: FileNotFoundException) => Left(exception.getMessage)
    case Failure(exception) => Left(exception.getMessage)
  }

  println(result)*/

 /* //Creating files
  val file = new File("src/main/resources/movie_ratings_new.csv")

  val pw = new PrintWriter(file)
  pw.println(1111)
  pw.close()*/
}
