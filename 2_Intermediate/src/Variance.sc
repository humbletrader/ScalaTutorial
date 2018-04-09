// covariance:
// A <: B -> T(A) <: T(B)
//
// Example:
// Integer <: Number -> Integer[] < Number[]
// Integer i = Integer.valueOf(10)
// Number n = int
// Integer[] intArray = new Integer[]{1,2,3}
// Number[] nbrArray = intArray

//
// contra-variance:
// A <:B -> T(B) <: T(A)
//
//
// invariance:
// A <: B ->  no relation between T(A) and T(B)
// Integer i = Integer.valueOf(10)
// Number nbr = i
// List<Integer> listOfInt = Array.asList(1,2,3)
// List<Object> listOfObj = listOfInt // not compilable