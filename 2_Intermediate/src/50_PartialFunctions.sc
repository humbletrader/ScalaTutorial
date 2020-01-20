// A partial function is a subclass of Function1
// it only covers partially the domain of objects
val partialFunction = new PartialFunction[Int, String]{
  def apply(i: Int): String = {
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

val composedPartialFunction = one orElse two orElse other
composedPartialFunction(5)

//partial functions are accepted in SOME collection methods
List(1,2,3).collect(composedPartialFunction) //returns List( one, two, other value)
//List(1,2,3).map(partial) //compilation error as map does not expect a PartialFunction

//inline partial functions
List(1,2,3, "four").collect{case i: Int => i * 2}

//notice how the partial function filtered the string value
//as opposed to a similar method which does not require a partial function

List(1,2,3, "four")

//usage or Seq, Map as partial functions
val seqAsPartialFunction = Seq("cat", "dog", "frog")
seqAsPartialFunction.isDefinedAt(0) //true
seqAsPartialFunction(0) //cat
seqAsPartialFunction.isDefinedAt(5) //false

Seq(1,2,100) collect seqAsPartialFunction //List(dog, frog)
//or even
Seq(1,2,100) collect Seq("cat", "dog", "frog") //List(dog, frog)

//lifting partial functions
val partialFnc : PartialFunction[Int, String] = Map(1 -> "one", 2 -> "two", 3 -> "three")
val totalFunction = partialFnc.lift
totalFunction(10) //None
totalFunction(2) //two
