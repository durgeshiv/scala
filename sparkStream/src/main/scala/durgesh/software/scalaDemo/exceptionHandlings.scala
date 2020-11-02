package durgesh.software.scalaDemo

import scala.util.{Failure, Success, Try}

object exceptionHandlings extends App {

  val fl = 4.5447



  val result =   Try {

    fl.toFloat

   // 1/0
  }


  result match {
    case Success(value) => println("Success :: " + value )
    case Failure(exception) =>  {
      println("Failure :: ")
      println(exception.getStackTrace.mkString)
      println(exception.getMessage)
    }
  }
}
