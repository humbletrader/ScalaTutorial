def isPalindromeBuiltin(l : List[Int]) : Boolean = {
  l == l.reverse
}

def isPalindromeOptimized(a : Array[Int]) : Boolean = {
  val halfSize = a.size / 2
  (0 to halfSize).forall{idx =>
    a(idx) == a(a.size - idx - 1)
  }
}

val list = 1::2::3::4::3::2::1::Nil
println(isPalindromeBuiltin(list))
println(isPalindromeOptimized(list.toArray))
