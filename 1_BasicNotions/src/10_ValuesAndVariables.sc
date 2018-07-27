///////////////////////////////////////////
// IMMUTABLE VALUE DEFINITION
//////////////////////////////////////////
val one: Int = 1

//////////////////////////////////////////
//  MUTABLE VALUE DEFINITION
//////////////////////////////////////////
var mutableOne : Int = 1

//immutable value definition having the type inferred from the right hand side
val two =  1+1

//error below (re-assingnment to val)
//two = 3

var three = 1+2 //type inferred from right
//re-assignment to var is fine
three = 4

//the third kind of variables is def
def four = 4
//error below (re-assignment to val)
//four = 5

//CONCLUSION
//val -     defines an immutable label for the right side content which is eagerly/immediately
//          evaluated only once (i.e. evaluated by value).
//var -     defines a mutable variable, initially set to the evaluated right side content
//def -     defines an immutable label for the right side content which is lazily evaluated
//          every time it is called (e.g. evaluation by name)
//lazy val- immutable label for the right hand side content which is eagerly
//          evaluated the first time it is called
//


//val evaluated immediately and only once
val proofVal = {
  println("the proofVal expression is being evaluated")
  util.Random.nextInt
}

//var evaluated immediately only once
var proofVar = {
  println("the proofVar expression is being evaluated")
  util.Random.nextInt
}

//lazy val evaluated at the fist use (in REPL may not be obvious)
lazy val proofLazyVal = {
  println("the proofLazyVal expression is being evaluated")
  util.Random.nextInt
}

println(proofLazyVal) //this should trigger the evaluation of lazyVal
println(proofLazyVal) //same value as above

//def evaluated every time
def proofDef = {
  println("the proofDef expression is being evaluated")
  util.Random.nextInt
}

//nothing is printed at this moment for proofDef

println(proofDef) //first use returns a number
println(proofDef) //second use returns another number ( proof that the expression is evaluated every time)




