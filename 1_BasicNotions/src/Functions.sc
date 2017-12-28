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


//anonymous function
(x: Int) => x + 7

//anonymous function spanning multiple lines
{i : Int =>
  println("this is the first line")
  i * 2
}

// save an anonymous function into a val
val thisIsAFunction = (i:Int) => i * 2
thisIsAFunction.getClass


