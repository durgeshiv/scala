package durgesh.software.scalaDemo.functions

object DefaultAndNamedParams extends App {

  def add(x: Int, y: Int) = {
    x + y
  }

  //Normally we pass values to a function as below
  println(add(10,20))
  //Suppose if we want to assign some default value to a function
  // this can be done by

  def addDefault(a: Int, b: Int = 10) = { a + b}
  //calling above function
  println(addDefault(15)) // this is not giving any compilation error // sould give o/p = 25
  // as here it is assuming 15 as value of a
  // value of b is what we have explicitly specified

  // consider we want to give some default value to a and supply b manually
  def addReverseDefault(p: Int = 60, q: Int) = { p + q}
  //calling above function
   // println(addReverseDefault(10))  <-- this says unspecified value of q
    // because this is assuming value of p as 10 in serial order
  // println(addReverseDefault(,10)) <- this isn't working either

  // Only option we are left here is to reverse value of parameters for them to assume values
  // of first indexes
  println(addReverseDefault(50,40))
  // Also, note that if given values explicitly, default values will be over ridden




  // Above issue can be over come using Named Parameter
  println("Printing Named parameter using addReverseDefault")
  println(addReverseDefault(q = 10)) // Now this works

}
