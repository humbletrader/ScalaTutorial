// A partial function is a subclass of Function1
// it only covers partially the domain of objects
val partialFunction = new PartialFunction[Int, String]{
  def apply(i: Int): String ={
    return "one"
  }

  override def isDefinedAt(x: Int): Boolean = x == 1

}


//scala provides a shorthand for partial functions:  ( using case )
val one: PartialFunction[Int, String] = { case 1 => "one"}
one.isDefinedAt(1) //true
one.isDefinedAt(2) //false
one(1) //returns "one"

val two : PartialFunction[Int, String] = { case 2 => "two"}
val other : PartialFunction[Int, String] = { case _ => "other value"}

val partial = one orElse two orElse other
partial(5)

//partial functions are accepted in SOME collection methods
List(1,2,3).collect(partial) //returns List( one, two, other value)
//List(1,2,3).map(partial) //compilation error as map does not expect a PartialFunction
