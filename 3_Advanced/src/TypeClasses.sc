class Address(street: String, nbr: Int)
class Person(firstName: String, lastName: String)

/**
  * this is the type class
  */
trait ToJson {
  def toJson(): String
}

/**
  * implicit class
  * @param pers
  */
implicit class PersonToJson(pers: Person) extends ToJson{
    def toJson() = "Person as json"
}


def jsonConsumer(jsonHolder: ToJson) =
  println(jsonHolder.toJson())


