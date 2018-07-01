//value classes are not stored in the heap
//they offer better performance as compared to the reference types

//see: https://docs.scala-lang.org/overviews/core/value-classes.html
//see the above link for limitations

//a value class can wrap a value type
class Currency(val amount: Float) extends AnyVal {
  def prettyPrint : String = s"$amount dollars"
}

//but it can also wrap a non value ( i.e a reference ) type
class PhoneNumber(val s: String) extends AnyVal {
  def digits : String = s.replaceAll("""\D""", "")
}


