def fnReturningOption(): Option[String] = Some("hello")

def fnReturningNone(): Option[String] = None

println(
for{
      r1 <- fnReturningOption()
      r2 <- fnReturningNone()
} yield {
  r1 + r2
}
)

//some common methods
Some("hello 1").flatMap( str => Some("enhanced "+str))
Some("hello 2").flatMap( str => None)
Some("hello 3").map( str => "enhanced "+str)
Some(100).fold(0.0){value => value + 1.0} //0.0 is the default value

//None is considered an empty container so flatMap returns also None
None.flatMap( str => Some("enhanced "+str))
None.isEmpty

//an example from Alvin Alexander's blog which shows how flat map works on Options
val strings = Seq("1", "2", "nonNumber", "3", "4", "anotherString")

def stringToNumber(str: String): Option[Int] = {
  try {
    Some(Integer.parseInt(str))
  } catch {
    case e: Exception => None
  }
}

strings.flatMap(str => stringToNumber(str))

//now the equivalent of flat map ( a map plus a flatten operation)
val optionalInts = strings.map(stringToNumber(_))
val flattenOptions = optionalInts.flatten //gets rid of None

