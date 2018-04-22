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
// Seq ( an ordered sequence of elements )
// Set ( a set of un-ordered elements )
// Map ( a map of key-value pairs)
//


//////////////////////////////////////////////////////////////////////////////////////////
//                     Traversables
//////////////////////////////////////////////////////////////////////////////////////////
val traversable = Traversable(1, 2, 3, 4, 5) //you will get a List ( default implementation returned by apply)

//important methods in traversables
traversable.head //1
traversable.tail //Traversable(2,3,4,5)

traversable.map{ nbr => nbr * 2}
traversable.partition(nbr => nbr % 2 == 0) //splits a traversable into two halves ( a tuple )
traversable.find(nbr => nbr % 2 == 0) //finds first
traversable.groupBy(nbr => nbr % 3) //creates a map with keys (0,1,2)

traversable.++(Traversable(6, 7, 8, 9)) // 1, 2, 3, .... 8, 9
traversable ++ Traversable(6, 7, 8, 9)
traversable.++:(Traversable(6, 7, 8, 9))  //6, 7, 8, 9, 1, 2, 3, 4, 5

traversable.reduceLeft((acc, elem) => acc + elem)   //
traversable.foldLeft(10)((acc, elem) => acc + elem) //the same as reduce but starting with 10
traversable./:(10)((acc, elem) => acc + elem)       //shortcut for fold left
traversable.scanLeft(10)((acc, elem) => acc + elem) // returns a list of intermediary results 10, 11, 13, 16, 20, 25

Traversable(Traversable(1,2), Traversable(3, 4, 5)).flatten
//important sub-traits : Iterable
//important concrete implementations: none


//////////////////////////////////////////////////////////////////////////////////////////
//                       Iterable - Iterator
//////////////////////////////////////////////////////////////////////////////////////////
val iterableSample = Iterable(1, 2, 3, 4, 5, 6, 7)         //returns a List (as default implementation returned by apply)
val iterator = iterableSample.iterator       //the most important method in the iterable trait
iterator.hasNext
iterator.next()

val groupsOfThree = iterableSample.grouped(3)   //returns an iterator
groupsOfThree.next() //List (1, 2, 3)
groupsOfThree.next() //List (4, 5, 6)
groupsOfThree.next() //List(7)
groupsOfThree.hasNext //false

val slidingWindowOfThree = iterableSample.sliding(3) //returns an interator
slidingWindowOfThree.next() // List (1,2,3)
slidingWindowOfThree.next() // List(2, 3, 4)
// ..

val anotherIterable = Iterable('a', 'b', 'c', 'd')
anotherIterable.zip(iterableSample) //List((a, 1), (b, 2), (c, 3), (d, 4))
anotherIterable.zipWithIndex  //List((a,0), (b,1), (c,2), (d,3))

//important sub-traits
//important concrete implementations


//////////////////////////////////////////////////////////////////////////////////////////
//                            Sequences
//////////////////////////////////////////////////////////////////////////////////////////
// sequence = an iterable with positions for each element and fixed length
val sequence = Seq(1, 3, 5, 7)

//important methods
sequence(1) //returns 3
sequence.indexOf(3) //returns 1
sequence.length //returns 4
sequence.:+(9) // List(1, 3, 5, 7, 9)
sequence :+ 9 //same as above
9 +: sequence // List(9, 1, 3, 5, 7)
sequence.+:(9) // same as above
sequence union Seq(2, 4, 6, 8)
sequence intersect Seq(1, 2, 3, 4, 5)
sequence.sorted
sequence.reverse

// notable sub-traits : IndexedSeq and LinearSeq
//LinearSeq : optimized for head and tail operations
//IndexedSeq: optimized for apply, length, update

//important concrete implementations:
// List, Stream : implementations for LinearSeq
// Array, ArrayBuffer, Vector: implementation for IndexedSeq

//Seq implements PartialFunction[Int, A] so you can easily write
sequence(3)
//sequence(100) //IndexOutOfBounds


//////////////////////////////////////////////////////////////////////////////////////////
//                            Sets
//////////////////////////////////////////////////////////////////////////////////////////
//sets are iterables that contain no duplicates and do not preserve order
val myPets = Set("cat", "dog", "mouse")
// important methods
myPets.contains("cat") //true
myPets("cat") //returns true ( because Set extends Function1 A => Boolean)
myPets + "bear"
myPets ++ (Set("bear", "deer", "monkey"))
myPets + ("bear", "deer") //adding the elements of a tuple
//important sub-traits: SortedSet
//important implementations: HashSet, BitSet, TreeSet


//////////////////////////////////////////////////////////////////////////////////////////
//                            Maps
//////////////////////////////////////////////////////////////////////////////////////////
val sampleMap = Map(1 -> "one", 2 -> "two", 3 -> "three")
val sampleMap2 = Map( (1, "one"), (2, "two"), (3, "three")) //same as above
//important methods:
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
sampleMap(1)//returns "one" ( not an option )
//sampleMap(5)//throws NoSuchElementException

for ((key, value) <- sampleMap) println(s"key=$key, value=$value")

//important sub-traits
//important concrete implementations: HashMap

