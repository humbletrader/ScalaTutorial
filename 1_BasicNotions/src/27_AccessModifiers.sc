//in scala the default (aka missing modifier) is public

package blah{
  class C {
    def foo = println("called foo ") //this hs public access
  }
  val c = new C
  c.foo //public
}


///////////////////////////////////////////////////////////////
//                  special access modifiers                 //
///////////////////////////////////////////////////////////////

package foo {

  package bar {
    class InsideBar(){

      private def fullPrivatMethod = println("full private")

      private[bar] def strangePrivateMethod() =
        println("private only inside bar package")
      private[foo] def privateUpToFooPackage =
        println("private up to bar package")
    }

    val insideBarInstance = new InsideBar()
    insideBarInstance.strangePrivateMethod
    insideBarInstance.privateUpToFooPackage
  }
}

package blah {
  val insideBarInstance2 = new InsideBar()
  insideBarInstance2.strangePrivateMethod
  insideBarInstance2.privateUpToPackage
}


