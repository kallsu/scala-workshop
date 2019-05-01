package it.kallsu.scala.gcommerce.audit

import it.kallsu.scala.gcommerce.logging.{ApplicationLogLevel, ApplicationLogger}
import org.slf4j.{Logger, LoggerFactory}

case class SimpleAuditor(val classToLog: String) extends Auditor with ApplicationLogger {

  override protected val callerClass: String = classToLog

  private val logger: Logger = LoggerFactory.getLogger(callerClass)

  override protected def writesLog(level: Int, message: String): Unit = {
    if (level == ApplicationLogLevel.ERROR || level == ApplicationLogLevel.WARNING)
      logger.error(message)
    else if (level == ApplicationLogLevel.INFO)
      logger.info(message)
    else
      logger.debug(message)
  }

  override protected def writeAudit[R](start: String,
                                       end: String,
                                       additionalMsg: String,
                                       callerFnResult: Option[R]): Option[R] = {

    // In this implementation I used the same logger methods. The domain can require the write into another
    // destination (DB, Service, etc.)

    // let me play a bit
    this.debug("Mirror mirror on the wall, who is the fairest one of all ?")

    if (callerFnResult.isDefined) {
      // Giorgio forgot to print the result using toString() method ....
      this.info(s"Start : [$start] -> End: [$end].\nMessage: $additionalMsg.\nResult: Success")

    } else {
      // None and not error
      this.info(s"Start : [$start] -> End: [$end].\nMessage: $additionalMsg.\nResult: None")
    }

    // work hard ... play hard
    this.debug("SnowWhite.")

    return callerFnResult
  }

}
