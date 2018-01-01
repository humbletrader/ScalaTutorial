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
//TODO: unapply method generated as well

