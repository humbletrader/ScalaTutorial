val potentialNumber = "Blah"
try{
  potentialNumber.toInt
}catch{
  case nbrFmtExc : NumberFormatException => " format exception "+nbrFmtExc.getMessage
  case e: Exception => "general exception"
}finally{
  println("this code is called no matter if an exception has been thrown")
}

//remember that everything in scala is an expression
//so try can return a value
val caca = try { potentialNumber.toInt }
           catch{ case _ => 0 }
           finally { println("the finally block does not participate in forming the returned value")}

////////////////////////////////////////
//scala does not have checked exceptions
////////////////////////////////////////


/////////////////////////////////////////
// using @throws annotation
/////////////////////////////////////////