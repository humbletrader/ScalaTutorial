//////////////////////////////////////////////////
// this is taken from
// http://www.artima.com/pins1ed/implicit-conversions-and-parameters.html
//////////////////////////////////////////////////
class Dollar(val amount: Double)
class Euro(val amount: Double)

implicit def dollarsToEuros(dolar: Dollar): Euro = new Euro(dolar.amount * 1.2)

//implicit conversion at work
val euroInstance: Euro = new Dollar(100)
println(euroInstance.amount) // prints 120

//the code above is equivalent to
val euroInstance2: Euro = dollarsToEuros(new Dollar(100))
println(euroInstance2.amount)


//another advantage is the implicit conversion
def functionWhichAcceptsOnlyEuros(euro: Euro) = println(euro.amount)

functionWhichAcceptsOnlyEuros(new Dollar(10))
//which is equivalend to
functionWhichAcceptsOnlyEuros(dollarsToEuros(new Dollar(10)))


//what happens when two implicit methods can be used by the compiler

implicit def eurosToDollars(euro: Euro) : Dollar = new Dollar(euro.amount * 10/12)
implicit def eurosToNewDollars(euro: Euro) : Dollar = new Dollar(1)

//val dollarInstance: Dollar = new Euro(120) // expression of type Euro doesn't conform to expected format Dollar



