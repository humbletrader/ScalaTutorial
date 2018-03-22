import scala.annotation.tailrec

//////////////////////////////////////////////////////////////////////
// Tail recursion is a special kind of recursion where the recursive call
// is the VERY LAST thing returned by the function and THE ONLY thing returned.
//
// Normal recursion puts all the argument variables on the stack when  a function calls itself.
// In Tail recursion, all it has to do is modify its parameter list then loop back to the beginning of the function
///////////////////////////////////////////////////////////////////////


//no tail recursion ( as the function returns n * factorial
def factorial(n: Int) : Int = {
  if(n == 1) 1
  else n * factorial(n-1)
}


factorial(5)


// a tail recursive factorial method
@tailrec
def tailFact(count: Int, accumulator: Int ) : Int = {
  // START
  if ( count == 1) accumulator
  else tailFact(count-1, count * accumulator) //when this returns a goto START will be executed with the new parameeters
}

tailFact(5, 1)
tailFact(3, 1)


//non tail recursive
def removeEmptyNonTailRecursive(list :List[Option[String]]) : List[String] = list match {
  case Nil => Nil
  case Some(head)::tail => head :: removeEmptyNonTailRecursive(tail) //<-- non tail recursive
  case None::tail => removeEmptyNonTailRecursive(tail)
}

removeEmptyNonTailRecursive(None::Some("string 1")::Nil)


//tail recursive
@tailrec
def removeEmpty(remainder: List[Option[String]], accum: List[String]) : List[String] = {
  remainder match {
    case Nil => accum
    case None :: tail => removeEmpty(tail, accum)
    case Some(head) :: tail => removeEmpty(tail, accum:+head)
  }
}


removeEmpty(Some("1")::Some("2")::Nil, Nil)
removeEmpty(None::Some("1")::Some("2")::None::Nil, Nil)