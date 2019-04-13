package common

// Peano numbers
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def predecessor: Nat = throw new Error

  override def successor: Nat = new Successor(this)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) this else throw new Error
}

class Successor(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def successor: Nat = new Successor(this)

  override def +(that: Nat): Nat = new Successor(n + that)

  override def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor
}


