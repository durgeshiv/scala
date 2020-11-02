package durgesh.software.scalaDemo.functions

object forComprehension extends App {

  // this is syntactic sugar for map/flatmap, improves readability
  // consider an example to multiply elements of a list by 2

  val lst = List(1,2,3,4,5,6,7,8)
  // can be done easily by using map
  println(lst.map(x => x * 2))
  // or
  println(lst.map( _* 2)) //  since there is only one input
  // similarly can be done by using for-comprehension as below ::
  val usingFC = for {
    x <- lst
  } yield x * 2

  println(usingFC)

  // similarly for a list of string
  val lstStr = List( "durgesh","agnihotri")
  val FCLS = for {
    x <- lstStr
  } yield x.toUpperCase

  println(FCLS)

  // Lets see a complicated example
  case class user(name: String, age: Int)

  val u1 = user("durgesh", 20)
  val u2 = user("agnihotri", 27)
  val u3 = user("anonymous user", 26)
  val ls = List(u1, u2, u3)

  //ls.map(_.name)
  val fcc = for {
    name <- ls
  } yield name.name

  println(fcc)

  // lets find out the names of users having age greater than 25
  println(ls.filter(_.age > 25).map(_.name))

  val agefilterName = for {
    x <- ls if x.age > 25
  } yield x.name

  println(s"Printing age filter , name using for comprehension and the outpu is $agefilterName")
}
