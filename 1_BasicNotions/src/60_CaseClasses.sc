/////////////////////////////////////////////////
// CASE CLASSES HAVE A LOT OF boilerplate code already generated
/////////////////////////////////////////////////
case class Person(name: String, relation: String)
val person = Person("John", "cousin") // note the missing new ( case classes have an apply method )

//Case class constructor parameters are val by default, so accessor methods are      generated for the parameters,
// but mutator methods are not generated
person.name
person.relation
person.toString   //good toString method generated
person.equals(Person("Doe", "father"))
person.hashCode() //nice hash code generated
val anotherPerson = person.copy() // copy method generated
anotherPerson == person

//an example with copy method ( and the difference between copy and clone)
val aThirdPerson = person.copy(relation = "brother") //returns Person(John, brother)

//an example with unapply (which is also generated for every case class)
person match {
  case Person(name, relation) => s"Person $name is in $relation to you"
  case _ => "unknown object"
}

///////////////////////////////////////////////////////////////
//                  inheritance
///////////////////////////////////////////////////////////////
case class Animal ()

case class Cat (name: String) extends Animal //error: case-to-case inheritance prohibited

val myCat = new Cat("Sisi")