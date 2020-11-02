package durgesh.software.scalaDemo

object OptionsExample {

  def main(args: Array[String]): Unit = {

    val name = null //"durgesh"
    val maybename : Option[String] = Option(name)


   // println(maybename.mkString)

    // to check and get value
    if (maybename.isDefined) {
      println(maybename.get)
    } else println("no value")

    println(maybename.getOrElse("default value"))

    val lst = /*List.empty*/ List(1,2,3)
    println(lst.headOption)
  }
}
