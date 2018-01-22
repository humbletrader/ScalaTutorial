//Arrays preserve order, can contain duplicates, and are mutable.
val arraySample = Array(1,2,3,2,3,1)
println(arraySample(4)) //prints 3
arraySample(4) = 10
println(arraySample(4))//prints 10


//Lists preserve order, can contain duplicates, and are immutable.
val alphabet = List("A", "B", "C", "D")
alphabet(3) //prints D
//alphabet(3) = "E" //error
2::1::3::Nil // another way of adding values to a list

//Sets do not preserve order and have no duplicates and are immutable
val myPets = Set("cat", "dog", "mouse")

//map initialization
val sampleMap = Map(1 -> "one", 2 -> "two", 3 -> "three")
val sampleMap2 = Map( (1, "one"), (2, "two"), (3, "three")) //same as above

sampleMap.filter( pair => pair._1 < 3) //ugly way of filtering/mapping a map
sampleMap.filter({case (int, str) => int < 3}) //nicer way of doing the same thing
sampleMap.filter {case (int, str) => int < 3} //even more simple without the parenthesis
sampleMap.get(1) // returns an Option
sampleMap.get(1).get
sampleMap.get(5)    //returns None
sampleMap.get(3) match {
  case Some(n) => println(s"consuming $n")
  case None => println(" the number does not exist in the map")
}

//////////////////////////////////////////////////////////////////////////////////////////
//                      COMMON COLLECTION METHODS                                       //
//////////////////////////////////////////////////////////////////////////////////////////

val numbers = List(1,2,3,4,5,6,7,8,9)
numbers.partition( _ %2 == 0) //returns a tuple with two lists (List(2,4,6), List(1,3,5,7.9))

List(1,2,3).zip(List("a","b","c")) // returns a list of tuples List((1,"a"), (2, "b"), (3, "c"))
List(List(1,2), List(3,4,5)).flatten // List(1,2,3,4,5)





//////////////////////////////////////////////////////////////////////////////////////////
//                       CODE SAMPLES WITH COLLECTION                                   //
//////////////////////////////////////////////////////////////////////////////////////////

//flatten an array of tuples
val input = Array( (1, Array("a", "b")), (2, Array("c", "d", "e")))
input.flatMap(pair => pair._2.map(s => (pair._1,s)))
input.flatMap{ case (nbr, arr) => arr.map(letter => nbr -> letter)} //same as above only more explicit

