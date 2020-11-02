package durgesh.software.scalaDemo.functions

object cBVcBN extends App {
  // this object is to learn and practice Call-by-value and Call-by-Name

  def getTime()  = {

    println("inside getTime function")
    System.nanoTime()
  }

  def CallbyValue( x: Long) = {
    println("inside call by value")
    println(s"value of x is $x")
    println(s"value of x is $x")
  }

  def CallbyName(x: => Long) = {
    println("inside call by name")
    println(s"value of x is $x")
    println(s"value of x is $x")

  }

  CallbyName(getTime())
  println("done calling Call by Name")
  CallbyValue(getTime())
  println("Done calling Call by Value")


  // Another best example for use of Call by Name
  // and example showing its real time usage

  val isInfoEnabled = true
  def logInfoCBV(x: String)  = {
    if(isInfoEnabled) {
      println("inside log infoe - Call by Value")
      println(s"logging info at user lever with details $x")
    }
  }

  val user  = "Durgesh"
  val age = 27

  // Now in above method im using x : String, which is call by value so, ever after
  // isINfoEnabled flag is set to false, entire function would be called as below

  println("Calling by value")
  logInfoCBV(s"User is $user and his age is $age")

}
