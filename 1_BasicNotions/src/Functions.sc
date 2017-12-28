//classic function definition
def addOne(x: Int): Int = x +1

//function definition with inferred return type
def addTwo(x: Int) = x+2
addTwo(7)

//classic no params function definition
def makeComputation(): Int = 1+2
makeComputation()
//in scala you can skip the parenthesis for
//functions without params
makeComputation

//this is not a function (see the ValuesAndVariables.sc)
def thisIsNotAFunction = 2+3
thisIsNotAFunction.getClass

//////////////////////////////////
// ANONYMOUS FUNCTIONS
//////////////////////////////////
(x: Int) => x + 7

//anonymous function spanning multiple lines
{i : Int =>
  println("this is the first line")
  i * 2
}

// save an anonymous function into a val
val thisIsAFunction = (i:Int) => i * 2
thisIsAFunction.getClass

//////////////////////////////////
//PARTIAL APPLICATION
//////////////////////////////////
def addTwoNumbers(a: Int, b: Int) : Int = a + b
val addSeven = addTwoNumbers(7, _:Int)
addSeven(8)

//////////////////////////////////
//CURRIED FUNCTIONS
//////////////////////////////////

//curry an existing function
def multiply(a: Int, b: Int) : Int = a * b
val curriedMultiply = (multiply _).curried
val timesTwo = curriedMultiply(2)
timesTwo(3)

//define a curried function ( no need to curry it afterwards)
def alreadyCurriedMultiply(a: Int)(b: Int) : Int = a * b
val timesThree = alreadyCurriedMultiply(3) _
timesThree(7)

//////////////////////////////////
// VARIABLE LENGTH ARGS
//////////////////////////////////
def yetAnotherFunction(vars : Int*) : Unit = {
  vars.foreach(println)
}

//TODO: function vs. method







