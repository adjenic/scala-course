package common

import scala.io.Source

object PhoneNumberTranslator {

  private val in = Source.fromFile("src/main/resources/forcomp/linuxwords.txt")

  private val words = in.getLines.toList.filter(word => word.forall(char => char.isLetter))

  private val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  /**
    * Maps mnem map to letter -> digit map
    */
  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnem; letter <- str) yield (letter, digit)

  /**
    * Maps a word to the digit string that represents it, e.g. "Java" -> "5282"
    */
  def wordCode(word: String): String =
    word.toUpperCase.map(charCode)

  /**
    * A map from digit strings to words that represent them
    * "5282" -> "Java", "Lava", "Kata"...
    * A missing string should map to the empty list
    */
  val wordsForNum: Map[String, Seq[String]] =
    words.groupBy(wordCode).withDefaultValue(Seq.empty)

  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number.take(split))
        rest <- encode(number.drop(split))
      } yield word :: rest
    }.toSet

}
