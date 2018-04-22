
//a for with no yield statement
for(i <- Vector(1, 2, 3);
    j <- Seq(4, 5, 6);
    k <- Array(7, 8, 9)) {
  println(s"""$i, $j, $k""")
}

//the statement above is equivalent to
Vector(1, 2, 3).foreach( i =>
    Seq(4, 5, 6).foreach( j =>
        Array(7, 8, 9).foreach( k =>
              println(s"""$i, $j, $k""")
        )))

//a for with yield statement
for(i <- Vector(1, 2, 3);
    j <- Seq(4, 5, 6);
    k <- Array(7, 8, 9)) yield {
  (i, j, k)
}

//the statement above is equivalent to
Vector(1, 2, 3).flatMap(i =>
  Seq(4, 5, 6).flatMap(j =>
    Array(7, 8, 9).map(k =>
      (i, j, k)
    )))

//so if the for-yield is used on a single collection then it is the equivalend of
//a simple map operation
val names = Seq("John", "Jane", "Oliver")

for{
  name <- names
} yield name + " jr"

//the equivalent to
names.map(name => name + " jr")


//for comprehensions with guard
for{
  name <- names
  if name.startsWith("J")
} yield {
  name.toUpperCase
}

//is equivalent to
names.withFilter(name => name.startsWith("J")).map(_.toUpperCase)


///////////////////////////////////////////////////////////////
//                    for comprehensions with <- and =
///////////////////////////////////////////////////////////////
for{
  name <- names
  nameLength = name.size
}yield{
  s"name=$name, length=$nameLength"
}

//is equivalent to
names.map(name => (name, name.size))
      .map{case (name, nameLength) => s"name=$name, length=$nameLength"}

//every datatype that supports filter, map, flatMap can be used in for comprehensions

for{
  firstName <- Some("John")
  lastName <- Some("Doe")
}yield {
  (firstName, lastName)
}

////////////////////////////////////////////////////////////////////////////////////////////
//                    Monads don't compose well
////////////////////////////////////////////////////////////////////////////////////////////

val namesDatabase = Map (
  "John" -> Some("Doe"),
  "Tarzan" -> None,
  "Jane" -> Some("Doe")
)

for{
  firstName <- List("John", "Tarzan", "Jane")
  lastName <- namesDatabase(firstName) //this one returns an Option but it compiles because it is on the last position
} yield{
  (firstName, lastName) //returns a (John,Doe), (Jane, Doe) set
}

//the equivalent of the for-comprehension above with flatMap/map
namesDatabase.keys.flatMap(firstName =>
  namesDatabase(firstName).map( lastName =>
    (firstName, lastName)
  ))

// almost the save for comprehension but the lastName is not the last in the for expression ( so it should support a flatMap)
for{
  firstName <- List("John", "Tarzan", "Jane")
  //lastName <- namesDatabase(firstName)// this returns an Option-monad but throws a compilation error ( type mismatch )
  //so in order to bypass it you should forcefully make it a List ( not exactly elegant)
  lastName <- List(namesDatabase(firstName).getOrElse("Unknown"))  // solution for the issue above (compilation erro)
  suffix <- List("jr", "sr")
}yield {
  (firstName, lastName, suffix)
}


//////////////////////////////////////////////////////////////////////////////////////////
//                       CODE SAMPLES WITH FLAT MAP VS FOR-COMPREHENSIONS              //
//////////////////////////////////////////////////////////////////////////////////////////

//flatten an array of tuples
val input = Array( (1, Array("a", "b")), (2, Array("c", "d", "e")))
input.flatMap(pair =>
  pair._2.map(s => (pair._1,s))
)

//same as above but using partial functions
input.flatMap{
  case (nbr, arr) => arr.map(letter => nbr -> letter)
}

//same as above using a for comprehension
for{
  pair <- input
  first = pair._1
  second <- pair._2
}yield{
  (first, second)
}