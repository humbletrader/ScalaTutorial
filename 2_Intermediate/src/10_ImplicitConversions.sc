class Dollar(val amount: Double)
class Euro(val amount: Double)

implicit def dollarsToEuros(dolar: Dollar): Euro = new Euro(dolar.amount * 1.2)

//implicit conversion at work
val euroInstance: Euro = new Dollar(100)
println(euroInstance.amount) // prints 120

//the code above is equivalent to
val euroInstance2: Euro = dollarsToEuros(new Dollar(100))
println(euroInstance2.amount)


//what happens when two implicit methods can be used by the compiler

implicit def eurosToDollars(euro: Euro) : Dollar = new Dollar(euro.amount * 10/12)
implicit def eurosToNewDollars(euro: Euro) : Dollar = new Dollar(1)

val dollarInstance: Dollar = new Euro(120) // expression of type Euro doesn't conform to expected format Dollar
println(dollarInstance.amount)


