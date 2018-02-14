def maxList[T](elements: List[T])(implicit orderer: T => Ordered[T]) : T =
  elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case head::tail =>
      val maxRest = maxList(tail)(orderer)
      if(orderer(head) > maxRest) head
      else maxRest
  }

maxList(List(1,2,4, 3))

maxList(List("c", "a", "b"))