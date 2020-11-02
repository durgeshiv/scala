package durgesh.software.scalaDemo

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object test extends App {

  val lst = List(1,2,3,4,5,8)
  val evenElementsIterator = Iterator.from(1,2).takeWhile(_ < lst.size).map(lst(_)).toList
  val oddElementsIterator = Iterator.from(0,2).takeWhile(_ < lst.size).map(lst).toList
  /*println(" printing even elements :: " + evenElementsIterator)
  println(oddElementsIterator)*/
  var max_profit = 0
  for( x <- 0 until evenElementsIterator.length) {
    max_profit = evenElementsIterator(x) - oddElementsIterator(x)
  }
  println("max profit is :: " + max_profit)

  // to check if elements of a list are odd or even
  val lst1 = List(16,5,25,19)

  val x: Int =  4 //lst1 <- 0 to lst1.length - 1
  //for x <- lst1 (
  x match {
    case n if (x % 2 == 0) => println("even")
    case _ => println("odd")
  }

  // to check length of elements of a list
  val lst2 = List("this","is","me")
  println(lst2.map(_.length))

  val lst3 = List("this","is","me",4)

  //var a  = null
  for ( n <- 0 until lst3.length ) {
    lst3(n) match {
      case x:String => println("this is string :: " + x)
      case y: Int => println("this is int :: " + y )

    }
  }

 /* //var strLst =  new ListBuffer[] //(String)
  lst3.map(x => x match {
    case a: String =>  strLst =  strLst + a //println("String :: " + a)
    case b => println(" Other" + b)
  })
  println(strLst)
*/
  /**
   * Create a Scala program and use an appropriate data structure to
   * present the following key and value pairs of children and their ages:
   * Bill is 9 years old, Jonny is 8 years old,
   * Tommy is 11 years old, and Cindy is 13 years old.
   * Sort out the corresponding child to age in reverse alphabet order.
   */

  val nameAndAge = Map(("Bill", 9), ("Jonny", 8), ("Tommy",7), ("Cindy", 13))
  println("sort by key - normal " + nameAndAge.toSeq.sortBy(_._1))
  println("sort by val :: " + nameAndAge.toList.sortBy((_._2)))
  println("sort by key, desc :: " + nameAndAge.toList.sortWith((_._1 > _._1)))

  /**
   *
   * Let us assume that you two shopping baskets with a bunch of items in each one.
   * The first contains elements: "Cake", "Milk", "Cheese", "Toilet Paper",
   * and the second one has the following items: "Bread", "Water", "Juice", "Milk", "Cheese".
   * Write a Scala program to find the common items between the two shopping baskets.
   * You can use whichever data structure that you feel is appropriate for this particular problem.
   */

  val basket1 = List("Cake", "Milk", "Cheese", "Toilet Paper")
  val basket2 = List("Bread", "Water", "Juice", "Milk", "Cheese")
  println("common items are :: " + basket1.intersect(basket2).mkString(","))

  /**
   * Assume a shopping basket with the following items:
   * "Milk", "Cheese", "Donuts", "Apples", "Bananas".
   * Represent the above items into an appropriate data structure,
   * and thereafter define and use a value function that will remove all fruit
   * items from the shopping basket. In other words, the shopping basket should
   * only contain items "Milk", "Cheese" and "Donuts".
   * Note also that the resulting output should be represented as an XML element format as shown below.
   * <items values= "Milk|Cheese|Donuts"></items>
   */


  /**
   * Assume the following lexical coupon codes: "A", "BB", "CCC", "DDDD", "EEEEE".
   * Write a Scala program to create a new set of coupon codes based on the above one.
   * The format for each coupon code should be as follows: "coupon code - i", where
   * the number i is derived from the length of each corresponding coupon code.
   * A-1
   * BB-2
   * CCC-3
   */
  // Soln :: Making 10 coupons
 /* val couponString = 'A' to 'Z' /// A,B,...Z
  println(couponString(5))
  var couponCode: String = null
  var finalCode: String  = null
  for ( x <- 1 to 5) { //1

    //
    couponCode = couponString(x).toString
    println("inside 1st loop"+couponCode)
    for (n <- 0 to x-2) { //0


      couponCode += couponCode  //B

      println("inside loop" + couponCode)

    }

    finalCode = couponCode + "-" + x

    println(finalCode)

  }

*/
  val preCoupon = List("A","BB","CCC","DDDD","EEEEE")
  val couponCode = preCoupon.map(x => x + "-" + x.length)
  couponCode.foreach(println)

  /**
   * Write a Scala program and use the Tuple type to represent items in a shopping baskets:
   * "T-Shirt", "Medium", 10.99
   * "Polo-Shirt", "Large", 4.99
   * "Vest", "Small", 5.99
   * "T-Shirt", "Small", 4.99
   * "T-Shirt", "Small", 4.99
   * You are free to use whichever data structure is appropriate to store the above-mentioned items.
   * The Scala program should then output all "T-Shirt" items in upper case format.
   * Note that all other items in the shopping basket should then be in the lower case format
   */

  val items  = List(("T-Shirt", "Medium", 10.99), ("Polo-Shirt", "Large", 4.99),("Vest", "Small", 5.99), ("T-Shirt", "Small", 4.99), ("T-Shirt", "Small", 4.99))
  items.map( x => println())




}
