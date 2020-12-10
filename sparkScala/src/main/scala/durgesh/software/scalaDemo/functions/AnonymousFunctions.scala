package durgesh.software.scalaDemo.functions

object AnonymousFunctions extends App {

  def inc2(x : Int) : Int = { x + 2 }

  println(inc2(10))
  // above function can also be written using string literal as below ::


  (y : Int) => y + 2
  // above statement can be called by assigning it to a variable as below :

  val striLiteral = (y : Int) => y + 2
  println(striLiteral(5))

  // Defining a function which takes no argument as input can be done as below ::
  def getDir() : String = {
    System.getProperty("user.dir")
  }
  // above function which takes no value and returns string can be written using literal as below ::

  val dir = () => System.getProperty("user.dir")
  println(dir)

}
