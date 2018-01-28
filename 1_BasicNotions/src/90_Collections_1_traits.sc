//////////////////////////////////////////////////////////////////////////////////////////
//  COLLECTION HIERARCHY  http://docs.scala-lang.org/resources/images/collections.png  //
//////////////////////////////////////////////////////////////////////////////////////////
//
//     Traversable ( foreach, head, tail, map, groupBy, partition, find )
//           ^
//           |
//         Iterable    ( iterator() over the elements, hasNext, next )
//     ^      ^      ^
//     |      |      |
//    Seq    Set     Map
//
// Seq ( a sequence of elements )
// Set ( a set of un-ordered elements )
// Map ( a map of key-value pairs)
//


//////////////////////////////////////////////////////////////////////////////////////////
//                     Traversables
//////////////////////////////////////////////////////////////////////////////////////////
val traversable = Traversable(1, 2, 3, 4, 5) //you will get a List ( default implementation returned by apply)
traversable.head //1
traversable.tail //Traversable(2,3,4,5)
traversable.map{ nbr => nbr * 2}
traversable.partition(nbr => nbr % 2 == 0) //splits a traversable into two halves ( a tuple )
traversable.find(nbr => nbr % 2 == 0) //finds first
traversable.groupBy(nbr => nbr % 3) //creates a map with keys (0,1,2)
//important sub-traits : Iterable
//important concrete implementations: none


//////////////////////////////////////////////////////////////////////////////////////////
//                       Iterable - Iterator
//////////////////////////////////////////////////////////////////////////////////////////
val iterableSample = Iterable(1,2,3)         //returns a List (as default implementation returned by apply)
val iterator = iterableSample.iterator       //the most important method in the iterable trait
iterator.hasNext
iterator.next()
//important sub-traits
//important concrete implementations


//////////////////////////////////////////////////////////////////////////////////////////
//                            Sequences
//////////////////////////////////////////////////////////////////////////////////////////
val sequence = Seq(1, 3, 5, 7)
// sequence = an iterable with positions for each element and fixed length
sequence(1) //returns 3
sequence.indexOf(3) //returns 1
sequence.length //returns 4
// notable sub-traits : IndexedSeq and LinearSeq
//important concrete implementations:


//////////////////////////////////////////////////////////////////////////////////////////
//                            Sets
//////////////////////////////////////////////////////////////////////////////////////////
val myPets = Set("cat", "dog", "mouse")
//Sets do not preserve order and have no duplicates
//important sub-traits
//important implementations: HashSet



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

//important sub-traits
//important concrete implementations: HashMap

//////////////////////////////////////////////////////////////////////////////////////////
//                      COMMON COLLECTION METHODS                                       //
//////////////////////////////////////////////////////////////////////////////////////////

val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
numbers.partition( _ %2 == 0) //returns a tuple with two lists (List(2,4,6), List(1,3,5,7.9))

List(1,2,3).zip(List("a", "b", "c")) // returns a list of tuples List((1,"a"), (2, "b"), (3, "c"))
List(List(1,2), List(3, 4, 5)).flatten // List(1,2,3,4,5)

//////////////////////////////////////////////////////////////////////////////////////////
//                      VIEW METHODS                                                    //
//////////////////////////////////////////////////////////////////////////////////////////

//transforming one collection into another (view methods)
//toArray
//toBuffer
//toIndexedSeq
//toIterator
//toList
//toMap
//toSeq
//toSet
//toStream
//toTraversable




//////////////////////////////////////////////////////////////////////////////////////////
//                       CODE SAMPLES WITH COLLECTION                                   //
//////////////////////////////////////////////////////////////////////////////////////////

//flatten an array of tuples
val input = Array( (1, Array("a", "b")), (2, Array("c", "d", "e")))
input.flatMap(pair => pair._2.map(s => (pair._1,s)))
input.flatMap{ case (nbr, arr) => arr.map(letter => nbr -> letter)} //same as above only more explicit

