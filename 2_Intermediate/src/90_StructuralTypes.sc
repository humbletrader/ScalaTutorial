// structural types rely on java reflection
def foo(a : { def toDouble(p: Int) : Double}) : String = {
  //here we use the input parameter functions
  a.toDouble(100).toString
}

//can be also expressed as
type ToDoubleConversion = {
  def toDouble(p: Int) : String
}