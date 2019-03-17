package it.kallsu.scala.exampleh1.objectoriented

/**
  * Trait of PIZZA
  */
trait Pizza {
  val name : String
}

/**
  * Concrete class of PIZZA trait.
  *
  * @param name
  */
class PizzaPlay(val name : String) extends Pizza {}

/**
  * I want create a new Self-type PIZZA.
  */
trait CompositePizza {

  val basePizza : Pizza

  val topping : String

  def getName() : String = {
    (s"base Pizza is ${basePizza.name} and topping is ${topping}")
  }
}

/**
  * This is my pizza.
  *
  * @param topping
  * @param basePizza
  */
class GiorgioPizza(val topping : String, val basePizza : Pizza) extends CompositePizza {
}

object Main2 {

  def main(args: Array[String]): Unit = {
    val myPizza = new GiorgioPizza(
      topping = "tomatoes and mozzarella",
      basePizza = new PizzaPlay(name = "pizza play no spicy")
    );

    // pronouce your name pizza ...
    println(s"Giorgio's pizza today is : ${myPizza.getName()}")
  }
}

