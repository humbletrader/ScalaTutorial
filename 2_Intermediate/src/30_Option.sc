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

Some("hello 1").flatMap( str => Some("enhanced "+str))
Some("hello 2").flatMap( str => None)
Some("hello 3").map( str => "enhanced "+str)

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

