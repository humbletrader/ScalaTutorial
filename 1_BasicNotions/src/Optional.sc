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
None.flatMap( str => Some("enhanced "+str))
