trait MySpecialType{
  def special : String
}

//T is a subtype MySpecialType
def requiredSubtype[T <: MySpecialType](a: T): Unit = {
  println(a.special)
}

// T is a supertype of MySpecialType
def requiredSuperType[T >: MySpecialType](a : T): Unit = {
  println(a.toString)
}
