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
tailFact(10, 1)