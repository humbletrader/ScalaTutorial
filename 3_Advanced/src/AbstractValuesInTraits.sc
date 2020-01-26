///////////////////////////////////////////////////////////
//           Avoid abstract val in traits                //
///////////////////////////////////////////////////////////

//copied from "Scala in depth" chapter 4 - Utilizing object orientation, section 4.1.2, page 71
trait Property{
  val name: String
  override val toString = "Property(" + name + ")"
}

val x = new Property{ override val name = "Hi"} //Property(null)
//because the linearization of x is :
// Anonymous > Property > AnyRef > Any
// when constructing the new Property is done first and new Anon() is second
x.toString


//solution 1: don't use abstract vals in traits
//solution 2:

class X extends {val name = "Hi"} with Property //Property(Hi)

new X

//solution 3 (related to solution 2)
new {val name = "Hi"} with Property

//solution 4: lazy toString
trait PropertyWithLazyToString{
  val name: String
  override lazy val toString = "PropertyWithLazy "+name
}

val y = new PropertyWithLazyToString {
  override val name: String = "Blah"
}

//read more here:
//https://docs.scala-lang.org/tutorials/FAQ/initialization-order.html

abstract class A {
  val x1: String
  val x2: String = "mom"

  println("A: " + x1 + ", " + x2)
}
class B extends A {
  val x1: String = "hello"

  println("B: " + x1 + ", " + x2)
}
class C extends B {
  override val x2: String = "dad"

  println("C: " + x1 + ", " + x2)
}

new C
new A{
  val x1 : String = "blah"
  println("Anon: "+x1 + ", "+x2)
}
