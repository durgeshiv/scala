package durgesh.software.scalaDemo.functions

import scala.annotation.tailrec

object recursionAndTailRecursion extends App {
  // lets create factorial function


  def factorial(x: Int) : BigInt = {
    if ( x<=1){
      1
    } else {
      x * factorial(x-1)
    }
  }
  println(factorial(1000))

  // above example is of Recursion where function is calling itself only
  // if we try to call function for 10,000 this will fail giving java.lang.StackOverFlow error
  // because stack memory is not  able to handle such large computation again and again
  //Lets try to implement Tail Recursion


  // A tail recursive function is just a function where very last action is the call to itself.
  //when we write recursive functions this way,
  //scala compiler can optimize the results in Bytecode.
  // so that the function requires only one stock frame -
  //as opposed to one stack frame for each level of recursion

  @tailrec
  def factorialTailRec(n : Int, result : BigInt) : BigInt = {
    if (n <=1) {
      result
    } else {
      factorialTailRec(n-1, n*result)
    }
  }

  println(factorialTailRec(50000,1))
}
