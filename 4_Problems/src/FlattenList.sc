def flatten(ls: List[Any]) : List[Int] = {
  val result : List[Int] = ls.flatMap {
    case l: List[_] => flatten(l)
    case i : Int => List(i)
  }
  result
}

println(
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
)

def myflatten(list: List[Any]) : List[Int] = {
  println(s"flattening $list")
  list match {
    case Nil => Nil
    case head::tail => head match {
      case h: Int => myflatten(tail).:+(h)
      case l : List[_] => myflatten(l) ++ myflatten(tail)
      case _ => throw new IllegalArgumentException("")
    }
  }
}

println(
  myflatten(List(List(1, 1), 2, List(3, List(5, 8))))
)