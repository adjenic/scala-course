package funsets

object Main extends App {
  import FunSets._
//  println(contains((x: Int) => x < 0, -2))
//  println(contains(singletonSet(1), 1))
//
//  println(union((x: Int) => x < 0, (x: Int) => x <= 0)(0))
//  println(filter(union(singletonSet(2), singletonSet(4)), (x: Int) => x % 2 == 0)(4))
//
//  println(intersect((x: Int) => x <= 0, (x: Int) => x == 0)(0))
//  println(diff((x: Int) => x >= 0, (x: Int) => x <= 0)(1))
//  println(filter((x: Int) => x > 0, (x: Int) => x > 2)(4))
//
//  println(forall((x:Int) => x % 2 != 0 && x <= 0, (x: Int) => x < 0))
//
//  println(exists((x:Int) => x > 50 && x <= 100, (x: Int) => x == 51))

  printSet(map((x:Int) => x > 0 && x <= 1000, (x: Int) => x * x))

}
