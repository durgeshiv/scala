package durgesh.software.scalaDemo.functions

object closures extends App {

  // instantiating below class to call function sayHello
  val objMyClosure = new myClosure
  val name = "Durgesh"
  println(objMyClosure.sayHello(name))
}

 class myClosure {
   var age = 10
   def sayHello(name : String) = {
     s"Hello $name, your age is $age" // here age is a free variable but name is a bound variable
   }
 }

// benefit ::
// you may have to define closures in order to access, uptodate run time configuration
