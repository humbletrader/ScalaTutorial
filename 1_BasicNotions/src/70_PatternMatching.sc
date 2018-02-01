/////////////////////////
// match on values
/////////////////////////
val x = 1

//(equivalent to java switch statement)
x match {
  case 1 => "One"
  case 2 => "Two"
  case _ => "some other value"
}

// another way of handling the default case
x match {
  case 2 => "two"
  case oops=> "default (unrecognized) value"+oops
}

//using if statements (guards) to case statements
x match {
  case i if i == 1 => "One"
  case i if i == 2 => "two"
  case _ => "some other value"
}

////////////////////////////////////
// no handling for default case generates an runtime error (MatchError)
///////////////////////////////////
x match {
  case 2 => "two"
  case 3 => "three"
  case oops => "comment this and you will get an error"
}

//////////////////////////////////
// matching multiple values
/////////////////////////////////
x match {
  case 1 | 3 | 5 | 7 | 9 => "odd digit"
  case 2 | 4 | 6 | 8 => "even digit"
  case _ => "number"
}

/////////////////////////
// match on types
/////////////////////////
def detectType(v: Any): String = {
  v match {
    case Int => "it's an integer"
    case Double => "it's a double"
    case _ => "another type"
  }
}

//if you want to use the type-casted variable
def detectType2(v: Any): String ={
  v match {
    case i: Int => "it's an integer"+i.isInfinity
    case a: String => "it's a string"+a
    case d: Double => "it's a double as whole "+d.isWhole()
    case a: Array[Int] => "array of integers"+a.length
    case _ => "it's something else"
  }
}

//matching on class members
class Person(val firstName: String, val lastName: String)
val pers1 = new Person("John", "Doe")
pers1 match {
  case _ if pers1.firstName == "Johny" => "The person has the first name Johny"
  case _ if pers1.firstName == "John" && pers1.lastName == "Doe" => "the most used fake name"
  case _ => "something else"
}

///////////////////////////////////////////
//    MATCH ON CASE CLASSES
///////////////////////////////////////////
trait Pet
case class Dog(name: String) extends Pet
case class Cat(name: String, age: Int) extends Pet
case class Fox() extends Pet

val test = new Dog("Puffy")
test match {
  case Dog("Lord") => "my dog's name is lord"
  case Dog(_) => "some kind of dog"
  case Cat("Puffy", 2) => "my cat's name is Puffy and she's very young"
  case Cat("Puffy", _) => "not so young puffy cat"
  case Fox() => "I have a fox"
  case _ => "some other kind of animal"
}


///////////////////////////////////////////
//    MATCH ON sequences, tuples,
///////////////////////////////////////////
List(1,2,3, 4) match {
  case List(0, _, _) => "a three-element list with 0 as the first element"
  case List(1, _*) => "a list beginning with 1, having any number of elements"
}


//////////////////////////////////////////
//   Adding variables to patterns (variable @ pattern)
//////////////////////////////////////////
//case c@Calculator(_, _) => "Calculator: %s of unknown type".format(c)



///////////////////////////////////////////
//    using Some and None
///////////////////////////////////////////




///////////////////////////////////////////
//  matching exceptions
///////////////////////////////////////////



///////////////////////////////////////////
//    switch annotation ( tableswitch and lookupswitch)
///////////////////////////////////////////