package it.kallsu.scala.workshop.h2.monads

object Monads {

  private val numList1 = List(1, 2)
  private val numList2 = List(3, 4)

  def monadExample1(): Unit = {
    numList1 flatMap { x =>
      numList2 map {
        y => x + y
      }
    }
  }

  def monadExample2(): Unit = {
    val sum: List[Int] = for {
      first <- numList1
      second <- numList2
    } yield (first + second)
  }
}
