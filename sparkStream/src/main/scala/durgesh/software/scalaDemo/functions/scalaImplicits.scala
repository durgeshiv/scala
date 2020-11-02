package durgesh.software.scalaDemo.functions

import scala.collection.immutable.LinearSeq
import scala.collection.mutable

object scalaImplicits extends App {

  def sayHello(name : String, prefix : String)  = s"$prefix, $name"

  val numbrr  = 10
  val line  : String = numbrr.toString
  println(line)


  println(line.isInstanceOf[String])

  val lst  = IndexedSeq(1,2,3)
  println(lst)

  println( " scala mutable linear seq ")
  val lst1 = mutable.LinearSeq("this","is","you")
  println(lst1)

  val mutIndex = mutable.IndexedSeq(1,2,3)
  println(mutIndex)


  println(" scala immutable linear seq ")
  val lst2 = LinearSeq("this","is","me")
  println(lst2)
 /* implicit def (input :Int)  = {
    val input
  }*/

}