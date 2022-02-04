//requirement: we want to be able to transform to JSON
// all our domain classes

//domain classes
case class Address(street: String, nbr: Int)
case class Person(firstName: String, lastName: String)

//i'm pretty lazy so i'll use String instead of Json
type JSON = String

/**
  * the type class
  * @tparam A
  */
trait JsonWriter[A]{
  def write(obj: A) : JSON
}

//type class instances
object JsonWriterInstances{
  implicit val personWriter: JsonWriter[Person] = new JsonWriter[Person] {
    override def write(obj: Person): JSON = s"JSON[${obj.firstName}]"
  }

  implicit val addressWriter : JsonWriter[Address] = new JsonWriter[Address] {
    override def write(obj: Address): JSON = s"JSON[${obj.street}]"
  }
}

////////////////////////////////////////////////////
//           CONSUMING TYPE CLASSES
////////////////////////////////////////////////////

//option 1 : Interface Object
object Json{
  def toJson[A](value: A)(implicit writer: JsonWriter[A]) : JSON =
    writer.write(value)

  def fancierToJson[A:JsonWriter](value : A) : JSON =
    implicitly[JsonWriter[A]].write(value)
}



//usage
import JsonWriterInstances._

Json.toJson(Person("Jon", "Doe"))

//option 2: Interface Syntax (extension methods / type enrichment / pimping )
//the most elegant
object JsonSyntax{
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]) : JSON = w.write(value)
  }
}

import JsonWriterInstances._
import JsonSyntax._

Person("Jane", "Doe").toJson
Address("USA, New York, Wall Street", 1).toJson
