//parenthesis vs curly braces


//////////////////////////////////////////////////////////////////
//                                                              //
//                   expressions and blocks of code             //
//                                                              //
//////////////////////////////////////////////////////////////////

( 5 + 1) // this is an expression

( 5 +
  1 +
  2) //this is another expression

{ 5 + 1} //this is a block of code which can be more complex and can include sub-expression
{ 5+
  4
  3}

{
  println("code block start") // a block can contain statements
  import scala.collection.JavaConverters._ // a block can contain imports

  (5 + 1) // a block can contain expressions - of course the parens are optional

  val list : java.util.List[String]= new java.util.ArrayList() //
  list.add("four")
  list.add("five")
  println("code block end") //statmenets

  (list.asScala.size + 1)// this is an expression an is the return statement of the block
}

//braces can be used also as partial functions when used together with case statement
val partial  : PartialFunction[String, Int] = { case str => str.length}

List(1,2,3).collect({case 1 => "one"}) //collect expects a partial function


//parenthesis and curly braces
// can be used interchangeably when passing param to method calls
//if and only if the method expects s single parameter
List(1, 2, 3).reduceLeft{ (agg, n) => agg + n}
List(1, 2, 3).reduceLeft{ _ + _ }
List(1, 2, 3).reduceLeft( (agg, n) => agg + n)
List(1, 2, 3).reduceLeft( _ + _ )

List(1 -> "a", 2-> "b", 3-> "c").map{ case (nbr, str) => 5.0 }

val funcWtthTwoParams = (a : Int, b : String) => b + a
val funcWithTuple = (tuple: (Int, String)) => tuple._2 + tuple._1
val funcWithTuple2 : ((Int, String)) => String = { case (a, b) => b + a }
val funcWithTuple3 : (Int, String) => String = { case (a: Int , b: String) => b + a.toString}

List(1 -> "a", 2-> "b", 3-> "c").map{ tuple => tuple._2 + tuple._1 }
List(1 -> "a", 2-> "b", 3-> "c").map( tuple => tuple._2 + tuple._1 )
List(1 -> "a", 2-> "b", 3-> "c").map( funcWithTuple)
List(1 -> "a", 2-> "b", 3-> "c").map{ case (a: Int, b: String) => b + a }
List(1 -> "a", 2-> "b", 3-> "c").map{ case (a, b) => b + a }


