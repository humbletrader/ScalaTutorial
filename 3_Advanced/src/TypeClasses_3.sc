//code from
//https://blog.scalac.io/2017/04/19/typeclasses-in-scala.html


//Type class is a class (group) of types, which satisfy some contract
// defined in a trait with addition that such functionality (trait and implementation)
// can be added without any changes to the original code.
trait Show[A] {
  def show(a: A) : String
}

object Show { //instances

  def apply[A](implicit sh: Show[A]) : Show[A] = sh

  def show[A: Show](a: A) = Show[A].show(a)

  implicit val intCanShow : Show[Int] = new Show[Int]{
    override def show(a: Int): String = s"int $a"
  }

  implicit class ShowOps[A: Show](val a : A) extends AnyVal{
    def show(implicit sh: Show[A]) = sh.show(a)
  }
}

//at this moment the usage would be
println(Show.intCanShow.show(20)) //prints "int 20"

//second phase (after adding def show)
import Show.intCanShow
println(Show.show(10))

//third phase (after adding ShowOps)
import Show.ShowOps
println(
  15.show
)