package durgesh.software.scalaDemo.oops

/**
 *
 *
 *
 * this class is all about constructors(primary constructors)
 */
object class2 extends App {

  val person = new Person("durgesh", "agnihotri")
  println(person)

}

class Person(var firstName: String, var lastName: String) {

  // state information
  val age = 10

  // behavior - means writing a method
 // def getName() = firstName + " " + lastName
 // def getAge() = age

  override def toString: String = s"my name is $firstName $lastName"

}
