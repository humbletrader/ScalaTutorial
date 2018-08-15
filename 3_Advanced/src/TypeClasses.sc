class Address(street: String, nbr: Int)
class Person(firstName: String, lastName: String)

/**
  * this is the type class
  */
trait JSONable {
  def toJson(): String
}

/**
  * implicit class
  * @param pers
  */
implicit class JSONablePerson(pers: Person) extends JSONable{
    def toJson() = "Person as json"
}

/**
  * this is the consumer of json ... it could have been anything else
  * @param jsonHolder
  */
def jsonConsumer(jsonHolder: JSONable): Unit =
  println(
    s""" consuming ....
       |
       | ${jsonHolder.toJson()}
       |
     """.stripMargin)

jsonConsumer(new Person("Jon", "Doe"))


