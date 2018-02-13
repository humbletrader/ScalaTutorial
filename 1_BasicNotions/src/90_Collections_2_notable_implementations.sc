//lists
//Lists preserve order, can contain duplicates, and are immutable.
//the standard list in scala is a linked list
//pretty-much used in functional / recursive constructions
val alphabet = List("A", "B", "C", "D")
alphabet(3) //prints D
//alphabet(3) = "E" //error
2::1::3::Nil // another way of adding values to a list

//linked lists

//streams
//a stream is a list whose elements are computed lazily
//because of the laziness, a stream can be infinite
val stream = Stream(1, 2, 3) // in the console this prints Stream (1, ?)
val stream2 = 1 #:: 2 #:: 3 #:: Stream.empty // the same as above

//vectors
val vector = Vector(1, 2, 3, 4, 5, 6)
vector :+ 7  //append one element
vector.:+(7) //append

vector ++ Vector(7, 8, 9)//append multiple elements

vector.+:(7) //prepend one element
7 +: vector //prepend
Vector(7, 8, 9) ++: vector  //prepend multiple elements
//a Scala method name that ends with the : character is right-associative,
// meaning that the method comes from the variable on the right side of the expression. Therefore, in these examples, the methods
// actually come from the variable a on the far right side of the expression

//ranges
val rangeExample = Range(1,5)
val secondRange =  1 to 5


//buffers


//stacks and queues


//priority queue

