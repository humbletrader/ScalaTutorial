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
//def - defines an immutable label for the right side content which is lazily evaluated - evaluate by name.
//val - defines an immutable label for the right side content which is eagerly/immediately evaluated - evaluated by value.
//var - defines a mutable variable, initially set to the evaluated right side conten

def anotherFour = 1+3
//anotherFour has not been evaluated at this point
//only when the call below is done it will be evaluated
anotherFour






