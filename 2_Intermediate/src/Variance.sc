import sun.security.krb5.internal.PAEncTSEnc

//Variance: how parameterized types behave under subtyping
// covariance:
// if A <: B then T(A) <: T(B)
//Example
//Integer <: Number
//Option[Integer] <: Option[Number]  (check the implementation of Option[+A]
val optionOfInt : Option[java.lang.Integer] = Option(123)
val optionOfNumber : Option[java.lang.Number] = optionOfInt //covariance

// Example:
// bad implementation of java arrays
// Integer <: Number -> Integer[] <: Number[]
// Integer i = Integer.valueOf(10)
// Number n = int
// Integer[] intArray = new Integer[]{1,2,3}
// Number[] nbrArray = intArray
//
//
// contra-variance:
// if A <:B then T(B) <: T(A)
//
class Writer[-T] {
  def write(value: T) = s" writing $value of type ${value.getClass}"
}
val nbrWriter : Writer[Number] = new Writer[Number]
val intWriter : Writer[Integer] = nbrWriter


//
// invariance:
// A <: B ->  no relation between T(A) and T(B)


// Note: in java the variance is declared at call site
// while is scala the variance is declared when defining the type
//java:
//util.List[P <: Number] blah = util.Arrays.asList(Integer.valueOf(1), java.lang.Double.MIN_VALUE, java.math.BigDecimal.ONE)
//List<Number> numbers = blah //ie. blah is an extension of List<Number>
//scala:
//class List[+A]


// Integer i = Integer.valueOf(10)
// Number nbr = i
// List<Integer> listOfInt = Array.asList(1,2,3)
// List<Object> listOfObj = listOfInt // not compilable

//Other examples
abstract class Animal{
  def name : String
}
abstract class Pet extends Animal
case class Cat (name : String) extends Pet
case class Dog (name : String) extends Pet

//the covariant containers (producer of Pets)
class Box[+A](wrapped: A){
  def getContents : A = wrapped
  //covariant type A occurs in contravariant position
  //def add(another: A) : Boolean = ???
}

val gift : Box[Pet] = new Box(Cat("jerry"))
gift.getContents


//consumer of animals
abstract class Keeper[-A]{
  def watch(a : A) : Unit

  //contravariant type A occurs in covariant position
  //def getWatched : A
}

//a zookeeper is able to watch any kind of animal
class ZooKeeper extends Keeper[Animal]{
  override def watch(a : Animal) : Unit = ???
  //override def getWatched : Animal = ???
}

//therefore the zookeeper is able to watch my dog
val dogKeeper : Keeper[Dog] = new ZooKeeper
dogKeeper.watch(Dog("blah"))









