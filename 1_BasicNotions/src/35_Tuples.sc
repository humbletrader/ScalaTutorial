//A tuple groups together simple logical collections of items without using a class.
val tupleOfTwoElements = Tuple2(1, "a")
val tupleExample = (1, "a")

//accessing the members
tupleExample._1
tupleExample._2

//another way of writing a tuple
val secondTupleExample = 2 -> "b"
secondTupleExample._1

val tupleWithThreeElements = (1, "one", "uno")
tupleWithThreeElements._1
tupleWithThreeElements._2

val tupleWithThree = 2 -> ("two" -> "due")