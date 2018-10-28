case class Person(firstName: String, age: Int)

//type class
trait ToJson[A]{
  def objToJson(obj : A) : String
}

//type class instances
object Instances{

  implicit val personToJson = new ToJson[Person] {
    def objToJson(person: Person) : String = s"${person.firstName} as json"
  }

  import Syntax.JsonOps

  implicit def listToJson[T](implicit typeCls: ToJson[T]): ToJson[List[T]] = new ToJson[List[T]] {
    def objToJson(list: List[T]): String =
      list.map(_.toJson).mkString("[", ",", "]")
  }

  implicit def optionToJson[T:ToJson] : ToJson[Option[T]] = new ToJson[Option[T]] {
    override def objToJson(obj: Option[T]): String =
      obj.map(_.toJson).getOrElse("Empty")
  }

}

// syntax object
object Syntax{
  implicit class JsonOps[A:ToJson](value : A){
    def toJson : String = implicitly[ToJson[A]].objToJson(value)
  }
}

//usage
import Syntax.JsonOps
import Instances.personToJson
Person("blah", 18).toJson


import Instances.listToJson
List(Person("a", 1), Person("b", 2)).toJson

import Instances.optionToJson
Option(Person("c", 3)).toJson

List(Some(Person("free", 4)), Option.empty[Person]).toJson