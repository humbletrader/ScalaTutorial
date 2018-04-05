/**
  *
  *
  * THIS CODE SHOULD NOT BE RAN IN THE SCALA REPL
  *
  *
  */

import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets.UTF_8
import scala.io.Source

val stringSourceAsBytes = "hellö wörld".getBytes(UTF_8)
val messedUpUTF8 = 128.toByte +: stringSourceAsBytes

// building the exception-bomb is harmless
val linesIterator: Iterator[String] = {
  val input = new ByteArrayInputStream(messedUpUTF8)
  Source.fromInputStream(input).getLines()
}

val combinedLines: String = try {
  // detonating the exception-bomb should be surrounded by try-catch
  linesIterator.mkString("\n")
} catch {
  case exc: Throwable => {
    println(" This is an exception !")
    ""
  }
}

println("combined lines is " + combinedLines)


