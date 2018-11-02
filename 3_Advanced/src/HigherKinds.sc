// Higher Kinds and Type Constructors

//  Kinds are like types for types. They describe the number of “holes” in a type.
//  We dis nguish between regular types that have no holes and “type construc-
//    tors” that have holes we can fill to produce types.
//    For example, List is a type constructor with one hole. We fill that hole by
//  specifying a parameter to produce a regular type like List[Int] or List[A] .
//    The trick is not to confuse type constructors with generic types. List is a type
//  constructor, List[A] is a type:
//  List  - type constructor, takes one parameter
//  List[A] -  type, produced using a type parameter

// Declare F using underscores:
def myMethod[F[_]] = {
  // Reference F without underscores:
  val functor = Functor.apply[F]
  // ...
}
