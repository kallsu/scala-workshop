package it.kallsu.scala.workshop.h2.hierarchy

/**
  * Trait of Message
  *
  * @tparam A
  * @tparam B
  */
trait Message[A, B] {

  val header: Option[A]

  val content: Option[B]
}

/**
  * No Message
  *
  * It happens more often than you think !
  */
object NoMessage extends Message[Any, Any] {
  override val header: Option[Any] = None
  override val content: Option[Any] = None
}

/**
  * Simple message class.
  */
class SimpleMessage(override val header: Option[String],
                    override val content: Option[String]) extends Message[String, String] {

  /**
    * Auxiliary constructor for simple message
    *
    * @param headerStr
    * @param contentStr
    */
  def this(headerStr: String, contentStr: String) = {
    this(Some(headerStr), Some(contentStr))
  }

}

/**
  * New trait to generate a message extension
  *
  * @tparam C
  */
trait MessageExtension[C] {
  val extension: C
}

/**
  * Complex message : Simple Message + Message Extension
  *
  * @param header
  * @param content
  * @param extension
  */
case class ComplexMessage(override val header: Option[String],
                          override val content: Option[String],
                          override val extension: String)
  extends SimpleMessage(header, content)
    with MessageExtension[String] {
}

object ComplexMessage {
  def apply(header: Option[String], content: Option[String], extension: String): ComplexMessage = {
    new ComplexMessage(header, content, extension)
  }
}