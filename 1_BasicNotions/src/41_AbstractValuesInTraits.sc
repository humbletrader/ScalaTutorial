///////////////////////////////////////////////////////////
//           Avoid abstract val in traits                //
///////////////////////////////////////////////////////////

//copied from "Scala in depth" chapter 4 - Utilizing object orientation, section 4.1.2, page 71
trait Property{
  val name: String
  override val toString = "Property(" + name + ")"
}

val x = new Property{ override val name = "Hi"} //Property(null)


//solution : don't use abstract vals in traits
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