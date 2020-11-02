package durgesh.software.scalaDemo.functions

object mapFlatMapandFilter extends App {

  //map transforms one form of data into another
  // frequently used with collections

  val lst = List(1,2,3,4,5)

  val a = lst.map(x => x*2)
  println(a)

  val strings = Array("durgesh", "agnihotri")

  println(strings.map( x => x.length))

  class user(val name: String, val age: Int)
  val u = new user("durgesh", 27)
  val u1 = new user("agnihotri", 30)
  val userName = List(u, u1).map(x => x.name)
  println(userName)

 println( lst.flatMap(x => strings.map(y => (x,y) )) )
  val nesTedList = List(List(1,2),List(3,4),List(5,6))
  println(nesTedList.map(x => x.mkString("-") ).mkString(","))
  // flattening
  println(nesTedList.map(x => x.map(y => y * 2)).flatten) // this is what a flatmap is
  println(lst.map(x => x * 2))
   ///  println(lst.flatMap(x => x * 2))
  // above cant be compiled as this list is already flattened and cannot be done any more

  println(lst.filter( x => x % 2 == 1))

  val str = "this is me"
  val splitStr  = str.split(",").toList
  println(splitStr.flatMap(x => x.toUpperCase))

  println(splitStr.flatten)
  println(nesTedList.flatten)
}