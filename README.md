# LearnScala
This is a collection of : 
 * scala scripts copied from various sources or implemented by myself while I was learning scala
 * links to various projects, tutorials, plugins

## Best scala books
 * Programming in Scala by Martin Odersky 
 * Programming Scala 2nd edition by Dean Wampler and Alexy Payne
 * Scala with Cats by Noel Welsh and Dave Gurnell (free e-book)
 * Scala in depth by Josh Suereth

## Useful links:

### Scala tutorials
* [Guide to Scala Collections](http://docs.scala-lang.org/overviews/collections/introduction.html)
* [Effective scala](https://youtu.be/TNSe0QzLx4E)
* [Variance](https://youtu.be/3tOMW2DkeS8)
* [Scala cheatsheet as jupyter notebook](https://riiswa.github.io/Scala-CheatSheet/)

### Scala collections
* [Collection guide](https://docs.scala-lang.org/overviews/collections/introduction.html)
* [Collections tips and tricks](https://pavelfatin.com/scala-collections-tips-and-tricks)
* [Conversions between Java and Scala collections](http://docs.scala-lang.org/overviews/collections/conversions-between-java-and-scala-collections.html)
* [Stream vs. View vs. Iterator](http://docs.scala-lang.org/tutorials/FAQ/stream-view-iterator.html)
* [Performance comparison](https://github.com/fosskers/scala-benchmarks/blob/master/README.org)

### Best practices and style guides
* [Scala best practices by Nicolas Rinaudo](https://nrinaudo.github.io/scala-best-practices/index.html)
* [Scala best practices by Alexandru Nedelcu](https://github.com/alexandru/scala-best-practices)
* [Scala style guide at scala.com](https://docs.scala-lang.org/style/)  
* [Scala style guide at databrics](https://github.com/databricks/scala-style-guide)
* [Strategic Scala Style: Principle of least power](http://www.lihaoyi.com/post/StrategicScalaStylePrincipleofLeastPower.html)
* [Design Patterns](https://pavelfatin.com/design-patterns-in-scala/)

### Functional programming
* [Typeclasses](https://blog.scalac.io/2017/04/19/typeclasses-in-scala.html)

### Scala exercises
* [Scala exercises for std lib, cats, doobie, fp in scala](https://www.scala-exercises.org/) maintained by Underscore.io 
* [99 problems in scala](http://aperiodic.net/phil/scala/s-99/)

### Plugins
* [scalastyle](http://www.scalastyle.org/) - the equivalent of checkstyle for scala (eclipse, intellij, maven, gradle)


## Todo: 
* common code in package objects

* function vs. method

* function composition

* structural types (duck typing), existential types

* more on variance :
    - contravariance example,
    - why immutable -> covariant and mutable -> invariant
    - type bounds vs. variance ( they're unrelated issues)

* patterns: 
    - stackable traits, 
    - type class, 
    - evidence class, 
    - cake pattern

* collections:
    - Builder, CanBuildFrom, MapLike, SeqLike
    - BigO reference for common methods in common implementations

* case classes : unapply && unapplySeq

* uniform access principle

* abstract types

* abstract types vs. parameterized types (generics)

* self type annotations

* override required and non-required

* traits can extend objects

* infix types

* unit type

* referential transparency ( see : https://pierangeloc.github.io/blog/2018/06/01/on-RT-and-FP )

* path dependent types

* type ascription

* TypeTag, ClassTag and WeakTypeTag (see: https://medium.com/@sinisalouc/overcoming-type-erasure-in-scala-8f2422070d20)

* Improve variance examples (see: https://www.benjamin.pizza/posts/2019-01-11-the-fourth-type-of-variance.html)

* F bounded types (see : http://tpolecat.github.io/2015/04/29/f-bounds.html )

* Other type bounds ( see : https://twitter.github.io/scala_school/advanced-types.html )

* improve partial functions ( see : https://blog.bruchez.name/2011/10/scala-partial-functions-without-phd.html )

