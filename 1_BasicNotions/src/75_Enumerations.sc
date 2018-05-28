object Weekdays extends Enumeration {
  type Weekdays = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}

//a better approach (but generating much more code in the background)
sealed trait WeekDay
case object Mon
case object Tue
case object Wed

//going back to Enumeration
//we can use the Value with an id, a String or an id + string
//see the following examples
object Breed extends Enumeration {
  type Breed = Value
  val doberman = Value("Doberman Pinscher")
  val yorkie   = Value("Yorkshire Terrier")
  val scottie  = Value("Scottish Terrier")
  val dane     = Value("Great Dane")
  val portie   = Value("Portuguese Water Dog")
}

Breed.values.foreach(println(_))

object Digit extends Enumeration {
  type Digit = Value

  val zero = Value(0, "zero")
  val one = Value(1, "one")
  val two = Value(2, "two")
}





