package it.kallsu.scala

/**
  * Representation of log level based on integer values
  */
object ApplicationLogLevel {

  val TRACE: Int = 1
  val DEBUG: Int = 2
  val INFO: Int = 3
  val WARNING: Int = 4
  val ERROR: Int = 5
}

trait ApplicationLogger {

  // Who Make the dirty job
  protected def writesLog(level: Int, message: String): Unit = ???

  /**
    * writes the debug message
    *
    * @param message log message log message
    */
  def debug(message: String): Unit = {
    writesLog(ApplicationLogLevel.DEBUG, message)
  }

  /**
    * write the debug message
    *
    * @param message log message
    * @param parameters
    * @param fn
    */
  def debug(message: String, parameters: Array[Any], fn: (String, Array[Any]) => String): Unit = {
    writesLog(ApplicationLogLevel.DEBUG, fn(message, parameters))
  }

  /**
    * writes the debug message
    *
    * @param message log message log message
    */
  def info(message: String): Unit = {
    writesLog(ApplicationLogLevel.INFO, message)
  }

  /**
    * writes the information message on log
    *
    * @param message    log message
    * @param parameters additional parameter to insert into the log message. Usage String.format syntax
    * @param fn
    */
  def info(message: String, parameters: Array[Any], fn: (String, Array[Any]) => String): Unit = {
    writesLog(ApplicationLogLevel.INFO, fn(message, parameters))
  }

  /**
    * Format the error message according the paramters.
    *
    * @param msg    log message to format
    * @param params additional parameter to insert into the log message. Usage String.format syntax
    * @param error  Option[Throwable]
    * @return full log message
    */
  protected def formatErrorForLog(msg: String, params: Array[String], error: Option[Throwable]): String = {
    val errorMsg = error match {
      case None => {
        ""
      }
      case Some(exc) => {
        exc match {
          case e: NullPointerException => {
            e.getMessage
          }
          case e2: NotImplementedError => {
            "I forgot to implements or override that."
          }
          case e3: Throwable => {
            e3.getMessage
          }
        }
      }
    }

    // check array
    if (params.isEmpty)
      s"$msg :: $errorMsg"
    else
      s"${String.format(msg, params)} :: $errorMsg"
  }

  /**
    * writes the warning messages
    *
    * @param message    log message
    * @param parameters additional parameter to insert into the log message. Usage String.format syntax
    * @param error      Option[Throwable]
    */
  def warning(message: String,
              parameters: Array[String] = Array.empty[String],
              error: Option[Throwable] = None): Unit = {

    // use a custom function to format the error message if it exists
    writesLog(ApplicationLogLevel.WARNING, formatErrorForLog(message, parameters, error))
  }

  /**
    * writes the error messages
    *
    * @param message    log message
    * @param parameters additional parameter to insert into the log message. Usage String.format syntax
    * @param error      Option[Throwable]
    */
  def error(message: String,
            parameters: Array[String] = Array.empty[String],
            error: Option[Throwable] = None): Unit = {

    // use a custom function to format the error message if it exists
    writesLog(ApplicationLogLevel.ERROR, formatErrorForLog(message, parameters, error))
  }
}
