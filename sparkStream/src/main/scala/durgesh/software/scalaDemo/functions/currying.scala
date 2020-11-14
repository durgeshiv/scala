package durgesh.software.scalaDemo.functions

object currying extends App {

  //consider a normal function
  def add(x: Int, y: Int) = x + y
  // above function can be curried as :::

  def addCurried(x : Int)(y: Int) = x + y
  //can be called as

  val a = addCurried(2) _

  val b = a(3)
  println(a)
  println(b)

  // converting a regular function into curried function
  val normalToCurriedFxn = (add _).curried
  println(normalToCurriedFxn)
}
