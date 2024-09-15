import scala.collection.mutable.ListBuffer
//find the last element of a list

def lastNthElement(lst: List[Int], n : Int) : Int = {
  if(lst.size < n) throw new NoSuchElementException("list does not have a nth element")

  lst.foldLeft(ListBuffer.empty[Int]){(lastNElements, newElem) =>
    if(lastNElements.size < n) lastNElements += newElem
    else lastNElements.tail += newElem
  }.head
}



val initial = 1::2::3::4::5::6::7::Nil
println(lastNthElement(initial, 4))

