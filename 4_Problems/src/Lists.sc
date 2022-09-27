//problems copied from http://aperiodic.net/phil/scala/s-99/

//Reverse a list
def reverse(lst: List[Int]) : List[Int] =
  lst.foldLeft(List[Int]())((agg, elem) => elem::agg)

reverse(List(1,2,3))

//eliminate consecutive duplicates of the elements of a list
case class Agg(list: List[Int], last: Int)

def compress(lst: List[Int]) : List[Int] =
  lst.foldLeft(Agg(Nil, lst.head))((agg, elem) => agg match {
    case Agg(Nil, _) => Agg(List(elem), elem)
    case Agg(res, lastElem) => if (elem == lastElem) agg else Agg(res :+ elem, elem)
  }).list
compress(List(1,2,2,2,3,4,4,2,2,2,5))