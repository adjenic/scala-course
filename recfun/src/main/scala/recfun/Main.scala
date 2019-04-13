package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    print("\nParenthesis are balanced - " + balance("an (example) ()()".toList))

    print("\nWays to return change - " + countChange(10, List(1,2,5)))
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {

    def factorial(el: => Int): Int =
      if (el == 0) 1 else el * factorial(el - 1)

    if (c == 0 || r == c) 1
    else factorial(r) / (factorial(c) * factorial(r - c))
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    val parenthesis = chars.filter(c => c == '(' || c == ')')

    def checkBalance(openParenthesisCounter: Int,
                     parenthesis: List[Char]): Boolean = {

      parenthesis match {
        case head :: tail if head == '(' =>
          checkBalance(openParenthesisCounter + 1, tail)
        case head :: tail if head == ')' && openParenthesisCounter != 0 =>
          checkBalance(openParenthesisCounter - 1, tail)
        case Nil => openParenthesisCounter == 0
        case _   => false
      }
    }
    if (parenthesis.isEmpty || parenthesis.head == ')') false
    else checkBalance(0, parenthesis)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }

}
