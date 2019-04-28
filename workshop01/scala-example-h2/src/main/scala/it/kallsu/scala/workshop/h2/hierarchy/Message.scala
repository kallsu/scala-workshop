package it.kallsu.scala.workshop.h2.hierarchy

/**
  * Trait
  *
  * @tparam A
  * @tparam B
  */
trait Message[A, B] {

  val header: Option[A]

  val content: Option[B]
}

/**
  * Singleton.
  * --> Also Null is an object
  */
object NoMessage extends Message[Any, Any] {

  override val header: Option[Any] = None
  override val content: Option[Any] = None
}

/**
  * Simple Message
  *
  * @param header
  * @param content
  */
class SimpleMessage(override val header: Option[String],
                    override val content: Option[String]) extends Message[String, String] {

  def this(headerStr: String, contentStr: String) = {
    this(Some(headerStr), Some(contentStr))
  }

}