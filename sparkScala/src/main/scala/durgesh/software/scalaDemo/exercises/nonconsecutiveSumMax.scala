package durgesh.software.scalaDemo.exercises

object nonconsecutiveSumMax extends App{


  val arr = Array(1,2,3,4,5)
  val even = Iterator.from(0,2).takeWhile(_ < arr.size).map(arr(_)).toList

  val nestedList = List(List((1,2,3),(4,5,6),(7,8,9)), List((9,8,7),(6,5,4),(3,2,1)))
  val flattened  = nestedList.flatMap(x => x.mkString(","))
  flattened.foreach(println)


/*

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
*/


}
