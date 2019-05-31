package Main

import scala.collection.mutable.HashMap

object Main extends App {
  val lst = Array(3, 2, 4)

  println(twoSum(lst, 6).mkString(" "))

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
//    val indicesByValue = xs.zipWithIndex.toMap
//    val matchIndices = xs map {x => indicesByValue get (target - x)}
//    val allSolutions = (xs.indices zip matchIndices) filter { case (_, m) => m.isDefined }
//    allSolutions collectFirst { case (i, Some(j)) => (i, j)}

    val map = (nums zip nums.indices).toMap
    val sol = nums map {x => map get (target - x)} // [matched indices]
    val legit_sol = (nums.indices zip sol) filter {case (_, x) => x.isDefined} // fitler out those is null
    val res = legit_sol collectFirst{case (i, Some(j)) if i != j => (i, j)}

    res match {
      case Some((i, j)) => Array(i, j)
      case None => throw new NoSuchElementException()
    }
  }
}
