package it.kallsu.scala.exampleh1.objectoriented

/**
  * Trait of PIZZA
  */
trait Pizza {
  val name: String
}

/**
  * Concrete class of PIZZA trait.
  *
  * @param name
  */
class PizzaPlay(val name: String) extends Pizza {}

/**
  * I want create a new Self-type PIZZA.
  */
trait CompositePizza {

  this: Pizza =>

  val topping: String

  def getName(): String = {
    (s"base Pizza is $name and topping is $topping")
  }
}

/**
  * This is my pizza.
  *
  * @param topping
  * @param basePizza
  */
class GiorgioPizza(override val name: String, val topping: String) extends CompositePizza with Pizza {
}

object Main2 {

  def main(args: Array[String]): Unit = {
    val myPizza = new GiorgioPizza(
      topping = "tomatoes and mozzarella",
      name = "Margherita")

    // pronouce your name pizza ...
    println(s"\nGiorgio's pizza today is : ${myPizza.getName()}")
  }
}

