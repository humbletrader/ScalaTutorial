object CallByName {
  //call by name vs. call by value for parameters
  val assertsEnabled = false

  //condition is a "by value parameter"
  def myAssertByValue(condition: Boolean)  = {
    println("inside assertion by value")
    if (assertsEnabled && !condition) throw new AssertionError
  }
  //condition is a "by name" parameter
  def myAssertByName(condition: => Boolean) = {
    println("inside assertion by name")
    if (assertsEnabled && !condition) throw new AssertionError
  }

  def myAssertWithFunc(condition : () => Boolean) = {
    println("inside assertion with function")
    if(assertsEnabled && !condition()) throw new AssertionError
  }

  lazy val fiveIsGreaterThan3 : Boolean = {
    println("evaluating condition 5 > 3")
    5 > 3
  }

  lazy val tenIsGreaterThan3 : Boolean = {
    println("evaluating condition 10 > 3")
    10 > 3
  }

  def main(args: Array[String]): Unit = {

    //here the condition is evaluated and the value
    //is sent to the myAssert function
    //The evaluation is done only once (before the method call)
    //in case the assertions are disabled (see assertsEnabled value above)
    //the condition is still evaluated
    myAssertByValue(fiveIsGreaterThan3)

    //the condition is evaluated only when used
    //this means it can be evaluated multiple times or never
    myAssertByName(tenIsGreaterThan3) //in this case (assertsEnabled = false) the condition is never evaluated

    //this is the same as "by name" only that is uglier to use
    myAssertWithFunc(()=> 20 > 3)

    //just for fun
    //we pass a function application to myAssert methods
    myAssertByValue((() => {
      println("evaluating 30 > 3")
      30 > 3
    })())

    myAssertByName((() => {
      println("evaluating 31 > 3")
      31 > 3
    })())

  }
}
