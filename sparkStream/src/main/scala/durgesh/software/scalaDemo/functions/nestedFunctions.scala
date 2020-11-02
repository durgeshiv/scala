package durgesh.software.scalaDemo.functions

object nestedFunctions {
  def main(args: Array[String]): Unit = {


    def maxof3(x: Int, y: Int, z: Int) : Int = {

      def max0f2(a: Int, b: Int) =  if (a >= b) a else b

      val r = max0f2(x , y)
      max0f2(r,z)
    }

    println(maxof3(5,-10,-5))
  }

}
