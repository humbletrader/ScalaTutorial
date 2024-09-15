import scala.collection.mutable.ListBuffer

//reverse a list recursive
def reverse(list: List[Int]) : List[Int] = {
  list match {
    case head::tail => reverse(tail) ++ List(head)
    case Nil => Nil
  }
}

//tail recursive
def tailRecursiveReverse(list:List[Int]) : List[Int] ={

  def internalReverse(l: List[Int], accum: ListBuffer[Int]) : List[Int] = {
    l match {
      case head::tail => internalReverse(tail, head +: accum)
      case Nil => accum.toList
    }
  }

  internalReverse(list, ListBuffer())
}

//non recursive
def nonRecursiveReverse(lst: List[Int]) : List[Int] = {
  lst.foldLeft(List.empty[Int]){(agg, newElem) =>
    newElem::agg
  }
}



val initial = 1::2::3::4::Nil
println(initial)
println(reverse(initial))
println(tailRecursiveReverse(initial))
println(nonRecursiveReverse(initial))