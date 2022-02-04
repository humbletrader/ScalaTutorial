//see https://stackoverflow.com/questions/4465948/what-are-scala-context-and-view-bounds

trait MySpecialString{
  def longer(b : String) : String
}

implicit def toSpecial(a : String) : MySpecialString

/////////////////////////////////////////////////////////////////////
//                 view bounds (deprecated as of scala 2.11)
/////////////////////////////////////////////////////////////////////

//View bounds are used to require an available implicit view for converting one type into another type
// View bounds are used mostly to take advantage of the pimp my library pattern, through which one "adds" methods to an existing class, in situations where you want to return the original type somehow.
// If you do not need to return that type in any way, then you do not need a view bound.
// The classic example of view bound usage is handling Ordered. Note that Int is not Ordered, for example, though there is an implicit conversion. The example previously given needs a view bound because it returns the non-converted type:
//   def f[A <% Ordered[A]](a: A, b: A): A = if (a < b) a else b
//This example won't work without view bounds. However, if I were to return another type,
// then I don't need a view bound anymore:
// def f[A](a: Ordered[A], b: A): Boolean = a < b

// T can be seen as a MySpecialType (through implicits)
def requiredImplicit[T <% MySpecialString](a: T, b: T): T = {
  if (a.longer(b)) a else b
}

// this is equivalent to
def requiredImplicitMoreVerbose[T](a: T, b: T)(implicit ev: T => MySpecialString) : T = {
  if(a.longer(b)) a else b
}

/////////////////////////////////////////////////////////////////////
//                 context bounds
/////////////////////////////////////////////////////////////////////

//Context bounds, similar to view bounds, declare that there must be an implicit value available with a given type
//Context bounds are mainly used in what has become known as typeclass pattern,
// as a reference to Haskell's type classes.
// Basically, this pattern implements an alternative to inheritance by making functionality available
// through a sort of implicit adapter pattern.

def contextBounds[T : Ordered](a: T): Unit = {
  println(a.toString)
}

//this is equivalent to
def moreVerbose[T](a: T)(implicit ev : Ordered[T]): Unit = {
  println(a.toString)
}
