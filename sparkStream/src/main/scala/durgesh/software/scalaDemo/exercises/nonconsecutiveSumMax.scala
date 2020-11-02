package durgesh.software.scalaDemo.exercises

object nonconsecutiveSumMax extends App{


  val arr = Array(1,2,3,4,5)
  val even = Iterator.from(0,2).takeWhile(_ < arr.size).map(arr(_)).toList



    def maxSum(numbers: Seq[Int]): Int = numbers match {
      case Nil => 0
      case Seq(n) => n
      case Seq(a, b) => Math.max(a, b)
      case head :: tail =>
        val currentAndSkipOne = head + maxSum(tail.tail)
        val skipCurrent = maxSum(tail)
        Math.max(currentAndSkipOne, skipCurrent)
    }
  println(maxSum(List(4,2,5)))


}
