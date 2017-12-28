class Calculator {
  val brand = "DELL"
  def compute(a: Int, b: Int) = a+b
}

val calc = new Calculator
calc.brand
calc.compute(1,2)


///////////////////////
// CONSTRUCTORS
///////////////////////

class Computer (brand : String) {
  //a constructor in scala = all code outside methods
  val color = if (brand == "APPLE") "white" else "black"

  //instance method ( nothing to do with the constructor)
  def compute(a: Int, b: Int) = a + b

  //this is also part of the constructor
  val chipMaker = if (brand == "DELL") {
    println("trying to detect the manufacturer of the chip in the constructor")
    "Intel"
  } else {
    println("trying to detect the manufacturer of the chip in the constructor")
    "some other manufacturer"
  }
}

val anotherCalc = new Computer("APPLE")
anotherCalc.color
anotherCalc.chipMaker
//brand ( the parameter send to the constructor is not available)
//anotherCalc.brand

//please note the val below ( which makes the brand available as an instance value)
class ComputerWithBrand( val brand: String) {

}

val thirdTypeOfComputer = new ComputerWithBrand("HP")
thirdTypeOfComputer.brand

class ComputerWithVarBrand( var brand: String){

}

val fourthTypeOfComputer = new ComputerWithVarBrand("blah")
fourthTypeOfComputer.brand
fourthTypeOfComputer.brand = "APPLE"
fourthTypeOfComputer.brand
