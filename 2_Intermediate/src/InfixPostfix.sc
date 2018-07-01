//from mathematics:
// infix operator notation :  3+4
// prefix operator notation:  + 3 4
// postfix operator notation 3 4 +

//normally in scala we should write
3.+(4) //awkward

//a better notation is the infix notation
// (supported by scala for methods with one argument)
3 + 4

//this means that any method that takes one single parameter can be written using infix notation
//instead of
Vector(1,2,3).mkString(",")
//we can write in infix notation
Vector(1,2,4) mkString ","
//for multiple params methods we can avoid the . but we should use the parentheses
Vector(1,2,3) mkString ("<", ",", ">")

//for methods that take no arguments we can avoid the . notation but it's not a good thing
//instead of
Vector(1,2,3).toList
//we can write
Vector(1,2,3) toList //called also postfix notation

