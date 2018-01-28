//A tuple groups together simple logical collections of items without using a class.
val tupleOfTwoElements = Tuple2(1, "a")
val tupleExample = (1, "a")

//accessing the members
tupleExample._1
tupleExample._2

//another way of writing a tuple
val secondTuple = 2.->("b")

//or, the more readable way
val secondTupleExample = 2 -> "b"
secondTupleExample._1

//deconstruction using tuples
val people = Vector(("John Doe", 34), ("Jeanny Doe", 35), ("their child", 10))
val (minors, adults) = people.partition(person => person._2 < 18)
minors // a Vector with one element
adults // a Vector with two person elements


val tupleOfThree = Tuple3(1, "one", "ein")
val anotherTupleOfThree = (2, "two", "zwei")
tupleOfThree._1
tupleOfThree._2
