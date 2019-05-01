package it.kallsu.scala.gcommerce.logging

import org.slf4j.{Logger, LoggerFactory}

/**
  * Simple application logger.
  *
  * @param classToLog
  */
case class SimpleAppLogger(val classToLog: String) extends ApplicationLogger {

  override protected val callerClass: String = classToLog

  private val logger: Logger = LoggerFactory.getLogger(callerClass)

  override protected def writesLog(level: Int, message: String): Unit = {
    if (level == ApplicationLogLevel.ERROR)
      logger.error(message)

    else if (level == ApplicationLogLevel.WARNING)
      logger.warn(message)

    else if (level == ApplicationLogLevel.INFO)
      logger.info(message)

    else if (level == ApplicationLogLevel.DEBUG)
      logger.debug(message)

    else if (level == ApplicationLogLevel.TRACE)
      logger.trace(message)

    else
      logger.debug(message)
  }

}

/**
  * Companion object of SimpleAppLogger
  */
object SimpleAppLogger {

  def apply(callerClass: String): SimpleAppLogger = new SimpleAppLogger(callerClass)

  def apply(callerClass: Class[Any]): SimpleAppLogger = new SimpleAppLogger(callerClass.getName)
}
