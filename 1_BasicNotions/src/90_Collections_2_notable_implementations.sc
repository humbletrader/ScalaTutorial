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
//because of the lazyness, a stream can be infinite
val stream = Stream(1, 2, 3) // in the console this prints Stream (1, ?)
val stream2 = 1 #:: 2 #:: 3 #:: Stream.empty // the same as above

//vectors

//ranges
val rangeExample = Range(1,5)
val secondRange =  1 to 5


//buffers


//stacks and queues


//priority queue

