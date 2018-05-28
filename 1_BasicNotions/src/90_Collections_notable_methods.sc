//////////////////////////////////////////////////////////////////////////////////////////
//                      COMMON COLLECTION METHODS                                       //
//////////////////////////////////////////////////////////////////////////////////////////

//map
Vector(1,3,5).map(i => i*2) //returns Vector[2,6,10]
Vector(1,3,5).map[Double, Seq[Double]](_ * 2)// Vector(2.0, 6.0, 10.0)

//partition
List(1, 2, 3, 4, 5, 6, 7, 8, 9).partition( _ %2 == 0) //returns a tuple with two lists (List(2,4,6), List(1,3,5,7.9))

//zip
List(1,2,3).zip(List("a", "b", "c")) // returns a list of tuples List((1,"a"), (2, "b"), (3, "c"))

//flatten
List(List(1,2), List(3, 4, 5)).flatten // List(1,2,3,4,5)

//tabulate
List.tabulate(5){ idx => idx+100} //creates a list with 5 elements (100, 101, 102, 103, 104)

//reduce
List(1,2, 3, 4, 5).reduceLeft((acc, value) => acc + value)

//fold
List(1, 2, 3, 4, 5).foldLeft("zero")((strAccum: String, value: Int) => strAccum + value)

//aggregate
//  - applies the first operation - seq - to the initial values in the list
//  - applies the second operation - comb - to the results of the initial seq operation
List("alpha", "beta", "gamma", "delta").aggregate(0)(
  (intAcc: Int, strVal: String) => intAcc + strVal.length, //<- this is seq-op
  (intAcc:Int, intVal: Int) => intAcc + intVal             // <- this is comb-op
)

//scan (like a fold but returns a collection of intermediary results
Vector(0,1,2).scanLeft("zero")((b: String, n: Int) => b + n) //Vector(zero, zero0, zero01, zero012)

//grouped
Vector(0,1,2,3,4,5,6,7,8,9).grouped(3).mkString("[", ",", "]") //[Vector(0, 1, 2),Vector(3, 4, 5),Vector(6, 7, 8),Vector(9)]

//sliding
Vector(0,1,2,3,4,5,6).sliding(3).mkString(",")//[Vector(0, 1, 2),Vector(1, 2, 3),Vector(2, 3, 4),Vector(3, 4, 5),Vector(4, 5, 6)]
Vector(0,1,2,3,4,5,6).sliding(3, 2).mkString(",")

//slice
Seq("a", "b", "c", "d", "e", "f", "g").slice(from = 2, until = 5) //List(c, d, e)

//////////////////////////////////////////////////////////////////////////////////////////
//                       CONVERSION METHODS                                             //
//////////////////////////////////////////////////////////////////////////////////////////

//toArray
//toBuffer
//toIndexedSeq
//toIterator
//toList
//toMap
Iterator( "a" -> "alan", "b" -> "bush", "a" -> "alice", "c" -> "chriss").toMap
//toSeq
//toSet
//toStream
//toTraversable
