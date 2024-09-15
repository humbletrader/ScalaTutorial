//eliminate consecutive duplicates of the elements of a list

//functional approach
def compress(lst: List[Int]) : List[Int] =
  lst.foldLeft(List.empty[Int])((agg, elem) => agg match {
    case Nil => List(elem)
    case init:+last =>
      if (elem == last) agg else agg :+ elem
  })
println(
  compress(List(1,2,2,2,3,4,4,2,2,2,5))
)
//recursive

def compressRecursive(ls: List[Int]) : List[Int] = {
  def internalCompress(result: List[Int], remaining: List[Int]) : List[Int] = {
    remaining match {
      case Nil => result
      case head::tail => result match {
        case Nil => internalCompress(List(head), tail)
        case init :+ last if (last == head) => internalCompress(result, tail)
        case _ => internalCompress(result :+ head, tail)
      }
    }
  }

  internalCompress(List.empty[Int], ls)
}

println(
  compressRecursive(List(1,2,2,2,3,4,4,2,2,2,5))
)