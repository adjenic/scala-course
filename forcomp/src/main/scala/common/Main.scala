package common

import common.PhoneNumberTranslator._
import common.NQueens._

object Main extends App {

    println(encode("7225247386"))
    println(encode("5282"))

    println(queens(4).map(show))


}
