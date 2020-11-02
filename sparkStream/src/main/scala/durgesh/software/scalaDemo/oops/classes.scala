package durgesh.software.scalaDemo.oops

// classes in scala are the blueprints and/or template for creating objects/instances
// they can contain values, variables, method, objects, traits, and classes.

// by default access modifier in scala is public.
class classes {

  val age = 10
  // if we do
  // private val age = 10 stmt at 20 will give error as this element will not be assessible from there
  

  def getA = age



}
 object test extends App {
   val instCl = new classes
   println(instCl.age)
 }
