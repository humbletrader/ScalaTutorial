class Parent {
  val publicField = 10
  private val privateField = 11
  protected val protectedField = 12
}

val parentInstance = new Parent()
println(parentInstance.publicField)
//println(parentInstance.protectedField)//protected field is inaccessible
//println(parentInstance.privateField) //private field is inaccessible

class Child extends Parent {

  def accessFieldsOfParent() = {
    println(publicField)
    println(protectedField) //OK
    //println(privateField) //NOK
  }
}



