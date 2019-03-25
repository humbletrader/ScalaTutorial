
//Arrays preserve order, can contain duplicates, and are mutable.
val arr = Array(1,2,3,2,3,1)
println(arr(4)) //prints 3

//mutability
arr(4) = 10
println(arr(4))//prints 10

//multi dimensional arrays
val matrix = Array.ofDim[Int](2,2)
matrix(0)(0) = 0
matrix(1)(0) = 1
matrix(0)(1) = 2
matrix(1)(1) = 3

// strings, string builders can be seen as sequences
