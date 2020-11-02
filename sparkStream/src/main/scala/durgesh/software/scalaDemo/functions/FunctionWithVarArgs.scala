package durgesh.software.scalaDemo.functions

object FunctionWithVarArgs extends App {

  def concat(inString : String*) : String = {
    inString.mkString("-")
  }
  println(concat("durgesh","agnihotri","faridabad"))

  def concatAll(inpString : String*) : String = {
    inpString.mkString("@")
  }

  println(concatAll(List("durgesh","Agnihotri" ) : _*))
}