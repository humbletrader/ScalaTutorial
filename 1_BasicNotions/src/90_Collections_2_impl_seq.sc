import scala.collection.immutable.Stack
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.parallel.immutable

// most contents copied from :
// https://docs.scala-lang.org/overviews/collections/seqs.html
// https://docs.scala-lang.org/overviews/collections/concrete-immutable-collection-classes.html


//                                    Seq
//               ------------------------------------------------
//               |                     |                        |
//           IndexedSeq              Buffer                   LinearSeq
//     -----------------          --------------          ----------------------------------------------
//     |       |       |          |            |          |      |     |       |         |             |
//   Array   Range   Vector    ArrayBuffer  ListBuffer   List  Queue  Stack  Stream  LinkedList   MutableList


////////////////////////////////////////////////////
//                       lists
////////////////////////////////////////////////////
// A List is a finite immutable sequence.
// They provide constant-time access to their first element as well as the
// rest of the list, and they have a constant-time cons operation for
// adding a new element to the front of the list.
// Many other operations take linear time.
//Lists preserve order, can contain duplicates, and are immutable.
//the standard list in scala is a linked list
//pretty-much used in functional / recursive constructions
val alphabet = List("A", "B", "C", "D")
alphabet(3) //prints D
//alphabet(3) = "E" //error
2::1::3::Nil // another way of adding values to a list

//pattern matching with lists
List(5,6,7) match {
  case Nil => "empty"
  case head :: tail if head > 0 => "has a non-zero head"
  case head :: tail => "zero head but full"
}

////////////////////////////////////////////////////
//                streams
////////////////////////////////////////////////////
//A Stream is like a list except that its elements are computed lazily.
// Because of this, a stream can be infinitely long.
// Only those elements requested are computed.
// Otherwise, streams have the same performance characteristics as lists.
val stream = Stream(1, 2, 3) // in the console this prints Stream (1, ?)
val stream2 = 1 #:: 2 #:: 3 #:: Stream.empty // the same as above

//a more complex example
def fibonacci(a:Int, b: Int) : Stream[Int] = a #:: fibonacci(b, a+b)
val firstFibonacciNbrs = fibonacci(1,1).take(7)
println(firstFibonacciNbrs.toList)


////////////////////////////////////////////////////
//                 vectors
////////////////////////////////////////////////////
//The Vector class provides an interesting compromise
// between indexed and linear access. It has both effectively
// constant time indexing overhead and constant time linear
// access overhead. Because of this, vectors are a good
// foundation for mixed access patterns where both indexed
// and linear accesses are used.

val vector = Vector(1, 2, 3, 4, 5, 6)
vector :+ 7  //append one element
vector :+ 10 :+ 11
vector.:+(7) //append

vector ++ Vector(7, 8, 9)//append multiple elements

vector.+:(7) //prepend one element
7 +: vector //prepend
Vector(7, 8, 9) ++: vector  //prepend multiple elements
//a Scala method name that ends with the : character is right-associative,
// meaning that the method comes from the variable on the right side of the expression.
// Therefore, in the examples above, the methods actually come from the variable a on the far right side
// of the expression

//pattern matching with Vectors (works with any other Seq )
Vector(5,6,7) match {
  case Seq() => "empty"
  case head +: tail if head > 0 => "has a non-zero head"
  case head +: tail => "zero head but full"
}

////////////////////////////////////////////////////
//                     ranges
////////////////////////////////////////////////////
//A Range is an ordered sequence of integers that are equally spaced apart.
// ranges are immutable

val rangeExample = Range(1,5)
val inclusiveRange =  1 to 5 //Range(1,2,3,4,5)
val exclusiveRange = 1 until 5 //Range(1,2,3,4)

////////////////////////////////////////////////////
//                   buffers
////////////////////////////////////////////////////
//mutable sequences
//they allow updates, insertions, removals and efficient additions at the end of the buffer
//new methods:
//        +=: and ++=: for addition at the front
//        insert, insertAll for elements insertion
//        remove and -= for removal of elements
// two notable implementations : ListBuffer and ArrayBuffer


// array buffers - are backed by Lists and allow
val lstBuf = ListBuffer(10,20,30)
lstBuf += 40
println(lstBuf) //prints ListBuffer(10,20,30,40)

val buf = ArrayBuffer(10,20,30)
buf.insert(3, 100)
println(buf) // prints ArrayBuffer(10,20,30,100)
50 +=: buf
println(buf) // prints ArrayBuffer(50,10,20,30,100)


//stacks
//If you need a last-in-first-out sequence, you can use a Stack.
// You push an element onto a stack with push,
// pop an element with pop, and peek at the top of the stack without removing it
// with top. All of these operations are constant time.
val stack = Stack.empty.push(1).push(2).push(3)
println(
  stack.top
)



// queues
//A Queue is just like a stack except that it is first-in-first-out
// rather than last-in-first-out.
val q = scala.collection.immutable.Queue
q

//hash tries

//red-black trees

