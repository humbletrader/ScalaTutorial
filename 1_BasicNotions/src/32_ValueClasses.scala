//value classes are not stored in the heap
//they offer better performance as compared to the reference types however there are limitations

//everything about value classes can be found here :
//https://docs.scala-lang.org/overviews/core/value-classes.html

//a value class can wrap a value type
class Currency(val amount: Float) extends AnyVal {
  def prettyPrint : String = s"$amount dollars"
}

//but it can also wrap a non value (i.e a reference) type
class PhoneNumber(val s: String) extends AnyVal {
  def digits : String = s.replaceAll("""\D""", "")
}

//Because the JVM does not support value classes, Scala sometimes needs to actually instantiate a value class
//A value class is actually instantiated when :
//    1. a value class is treated as another type.
//    2. a value class is assigned to an array.
//    3. doing runtime type tests, such as pattern matching.