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

/////////////////////////////////////////////////////////////////////
//                 view bounds
/////////////////////////////////////////////////////////////////////

//View bounds are used to require an available implicit view for converting one type into another type

// T can be seen as a MySpecialType (through implicits)
def requiredImplicit[T <% MySpecialType](a: T): Unit = {
  println(a.special)
}

// this is equivalent to
def requiredImplicitMoreVerbose[T](a: T)(implicit ev: T => MySpecialType) : Unit = {
  println(a.special)
}

/////////////////////////////////////////////////////////////////////
//                 context bounds
/////////////////////////////////////////////////////////////////////

//Context bounds, similar to view bounds, declare that there must be an implicit value available with a given type
def contextBounds[T : Ordered](a: T) = {
  println(a.toString)
}

//this is equivalent to
def moreVerbose[T](a: T)(implicit ev : Ordered[T]) = {
  println(a.toString)
}

