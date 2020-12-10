package durgesh.software.scalaDemo.oops

object classes3 extends App {

  //val person = new AnotherPerson("durgesh", "agnihotri")
  val person1 = new AnotherPerson("durgesh")
  val person2 = new AnotherPerson()
  println(person1.secondName)
  println(person2.secondName)
}

class AnotherPerson private(val firstName: String, val secondName: String) {

  def this(firstName: String) {
    this(firstName, "baba")
  }
  def this() {
    this("durgesh","agni")
  }

  override def toString: String = firstName
}