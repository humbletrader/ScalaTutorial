import scala.collection.mutable.ListBuffer
//problems copied from http://aperiodic.net/phil/scala/s-99/

//Reverse a list
def reverse(lst: List[Int]) : List[Int] =
  lst.foldLeft(List[Int]())((agg, elem) => elem::agg)

reverse(List(1,2,3))

//eliminate consecutive duplicates of the elements of a list
case class Agg(list : ListBuffer[Int], last : Int)

def compress(lst: List[Int]) : List[Int] =
  lst.foldLeft(Agg(ListBuffer[Int](lst.head), lst.head)) { (agg, elem) =>
    agg match {
      case Agg(_, lastElem) if lastElem == elem => agg
      case Agg(lst, lastElem) if lastElem != elem => Agg(lst.append(elem), elem)
    }
  }.list.toList

compress(List(1,2,2,2,3,4,4,2,2,2,5))