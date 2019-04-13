package common

object NQueens {

  def queens(n: Int): Set[List[Int]] = {

    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(Nil)
      else {
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
      }


    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val row = queens.length
      val queensWithRow = (row - 1 to 0 by -1) zip queens
      queensWithRow.forall {
        case (r, c) => col != c && math.abs(col - c) != row - r
      }
    }

    def placeQueensMap(k: Int): Set[List[Int]] =
      if (k == 0) Set(Nil)
      else
        placeQueensMap(k - 1).flatMap {
          queens =>
            (0 until n)
              .filter(col => isSafe(col, queens))
              .map(column => column :: queens)
        }

    placeQueensMap(n)
  }

  def show(queens: List[Int]) = {
    val lines =
      for (col <- queens.reverse)
        yield Vector.fill(queens.length)("* ").updated(col, "x ").mkString

    "\n" + lines.mkString("\n")
  }
}
