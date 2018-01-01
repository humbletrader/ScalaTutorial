import java.text.SimpleDateFormat
import java.util.Calendar

////////////////////////////////////////////////////////
//Objects are used to hold single instances of a class
////////////////////////////////////////////////////////

//we can use them like utility classes in java
object DateUtils {
  def getCurrentDate: String = {
    val dateFormat = new SimpleDateFormat("dd MMM yyyy")
    dateFormat.format(Calendar.getInstance().getTime())
  }
}

DateUtils.getCurrentDate

/////////////////////////////////////////////
//companion objects
/////////////////////////////////////////////
object Pizza{
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"
}

class Pizza (val crustType: String){
  override def toString(): String = {
    s"This pizza has ${crustType}"
  }
}

val pizza = new Pizza(Pizza.CRUST_TYPE_THIN)

//a class and its companion object can access each other’s private members

///////////////////////////////////
// COMPANION OBJECTS AS FACTORIES
///////////////////////////////////
object Person{
  def apply(name: String): Person = {
    new Person(name)
  }
}

class Person (val name: String){

}

val person = Person("John") //please note the missing new operator
