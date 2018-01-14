//Arrays preserve order, can contain duplicates, and are mutable.
val arraySample = Array(1,2,3,2,3,1)
println(arraySample(4)) //prints 3
arraySample(4) = 10
println(arraySample(4))//prints 10


//Lists preserve order, can contain duplicates, and are immutable.
val alphabet = List("A", "B", "C", "D")
alphabet(3) //prints D
//alphabet(3) = "E" //error

//Sets do not preserve order and have no duplicates and are immutable
val myPets = Set("cat", "dog", "mouse")

//map initialization
val sampleMap = Map(1 -> "one", 2 -> "two", 3 -> "three")
sampleMap.filter( pair => pair._1 < 3) //ugly way of filtering/mapping a map
sampleMap.filter({case (int, str) => int < 3}) //nicer way of doing the same thing
sampleMap.filter {case (int, str) => int < 3} //even more simple without the parenthesis

//flatten an array of tuples
val input = Array( (1, Array("a", "b")), (2, Array("c", "d", "e")))
input.flatMap(pair => pair._2.map(s => (pair._1,s)))

//COMMON COLLECITON METHODS
//filter, map, zip, flatten, flatMap