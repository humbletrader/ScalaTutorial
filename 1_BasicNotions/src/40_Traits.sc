trait Car {
  val brand: String
}

class BMW extends Car{
  val brand = "BMW" //required by Car trait
}

//traits can have implemented and un-implemented methods
trait Foo {
  def implemented(): Unit = {
    println("this is a trait implemented method")
  }

  def unimplemented(value: Int): Unit
}

class Bar extends Foo {
  override def unimplemented(value: Int): Unit = {
    println("this is implemented in the class but it uses the implemented method in the trait")
    implemented()
  }
}

val bar = new Bar
bar.unimplemented(7)


/////////////////////////////////
//  EXTENDING TRAITS ON THE FLY
/////////////////////////////////
trait TraitWithAllMethodsImplemented {
  def speak() = {
    println("Hello, I'm a trait !")
  }
}

class SimpleClass(var name: String) // it does not extend the trait

//it extends the trait at "instantiation time"
val onTheFlyTraitExtend = new SimpleClass("blah") with TraitWithAllMethodsImplemented
onTheFlyTraitExtend.speak()

///////////////////////////////////////////////////////////
//Limiting Which Classes Can Use a Trait by Inheritance
//////////////////////////////////////////////////////////
class Animal
trait TraitOfAnAnimal extends Animal
class Insect

// compilation error below (illegal inheritance)
//class Cockroach extends Insect with TraitOfAnAnimal


/////////////////////////////////////////////////////////
/// Marking Traits So They Can Only Be Used by Subclasses of a Certain Type
////////////////////////////////////////////////////////
class Plane
trait FlightCapable {
  this: Plane => {
    // more code here
  }
}
// compilation error ( illegal inheritance : self type FlyingSaucer does not conform to FlightCapable
//class FlyingSaucer extends FlightCapable

/////////////////////////////////////////////////////////
//// Ensuring a Trait Can Only Be Added to a Type That Has a Specific Method
////////////////////////////////////////////////////////

trait FlightCapable2 {
  this: { def fly() : Unit } => { //more code here
  }
}

class FlyingSaucer2 extends FlightCapable2 {
  def fly() : Unit = { // remove this and you will get a compilation error
    println("I'm flying ... ")
  }
}