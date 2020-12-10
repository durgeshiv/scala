package durgesh.software.scalaDemo

object fibonacci extends App {

  def nth(n: Int): Long = {
        n match {
          case 0 | 1 => n
          case _ => nth(n - 1) + nth(n - 2)
        }


  }

  println("fibonacci until 5 :: " + nth(5))
}
