package it.kallsu.scala.exampleh1.highorderfunction

import java.util.Date

import scala.util.Try

object HighOrderFunction {

  def main(args: Array[String]): Unit = {

    // list of integer
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // map
    val evenAsString: List[String] = list.map(x => {
      if (x % 2 == 0)
        s"$x is even"
      else
        s"$x is odd"
    })
    println(evenAsString)

    // flatten all as Char
    val evenAsString2 = evenAsString.flatMap(_.toUpperCase)
    println(evenAsString2)

    // fold left
    val total = list.foldLeft(0)(_ + _)
    println(s"FoldLeft: Total of the list is $total")

    // fold right
    val total2 = list.foldRight(0)(_ + _)
    println(s"FoldRight: Total of the list is $total2")

    // current time in milli-seconds
    val st: String = System.currentTimeMillis().toString

    // transform in java.util.Date
    val timeDate : Try[Date] = for {
      // convert in long
      ms <- Try(st.toLong)

      // try to convert
      time <- Try(new java.util.Date(ms))
      
    } yield (time)

    // resolve the try
    timeDate.map(d => {
      println(s"$st should be equal to ${d.getTime}")
    })


  }
}
