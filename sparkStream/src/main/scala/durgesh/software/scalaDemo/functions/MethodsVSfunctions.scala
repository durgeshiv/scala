package durgesh.software.scalaDemo.functions

object MethodsVSfunctions extends App {

  def inc(x : Int) = {
    x + 1
  }

  val incFxn = (x: Int) => x+1

  new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  /*new Function0[Int] {
    override def apply() = Int
  }*/

  // Difference b/w Methods and functions

  // 1.
  // considering Function2 as written above, forst two parameters(int, int) corresponds to its input.
  // while, third parameter corresponds to the output

  // Looking on the third ctrl + click on Functions will give a list until Function22
  // which means, functions can only contain 22 parameters, not more than that.

  //2.
  // Methods can't be a final value however,
  // Functions can be a final value

  // if we type method, without passing any parameter
  // inc , this will give compilation error

  // However,
  incFxn // this withStand on its own without giving any compilation error. Thus it can be final

  // Also, it can be checked ife incFxn is actually a function or not as below ::
  println(incFxn.isInstanceOf[Function1[Int,Int]]) // this should return true

  //3.
  // ETA - Expansion
  // When a function is expected but a method is provided, scala automatically converts it to a function
  //this is called ETA Expansion
  // since Map expects a function, but we'll supply a method and will see that it gets converted to function
  // automatically by scala.

  val myList = List(1,2,3,4)

  println( myList.map(inc))
  println(incFxn.apply(1))

  // 4.
  // Methods can have a no params list i.e methods can compile even if we do not give any parameter to it
  // Example as below ::
  val method1 = 10
  // But a function must have a params list, even a blank, but it should have a params list
  // Example as below ::
   // val method1Function = => 10 This wont compile, but
  val method1Function = () => 10 // this works, as we have given a blank parameter list


  //5.
  // MEthod name means invocation i.e. it invoked method
  // while Function name do not invoked it, means function itself.
  // considering method and function from 4.

  println(method1) // this will invoke method
  println(method1Function) // this will print some random value
  println(method1Function()) // NOw this will invoke a function
   // lets see their output

  //6.
  // WE can compose functions using andThen
  val fun1 = (x: Int) => x + 1
  val fun2 = (y : Int) => y * 20
  val resultFunction = fun1.andThen(fun2)(1)
  println(resultFunction)
}
