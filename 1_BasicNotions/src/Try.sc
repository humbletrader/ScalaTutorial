import java.lang.NumberFormatException

import scala.util.{Failure, Success, Try}

val string = "78 "

val nbrFromString =Try {
  string.toInt
}

nbrFromString.foreach(println) //does not print

val recoveredNbr = Try{
  string.toInt
}.recover{ //recover is like a map operation but for Failure
  case exc: NumberFormatException => 0
}

recoveredNbr.foreach(println) //prints 0

val recovered2Nbr = Try{
  string.toInt
}.recoverWith{ case exc : NumberFormatException => //recoverWith is like a flatMap operation but for Failure
  Try{
    string.trim.toInt
  }
}

recovered2Nbr.foreach(println) //prints 78


