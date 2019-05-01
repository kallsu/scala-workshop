package it.kallsu.scala.template.test.template.app

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import it.kallsu.scala.template.test.logging.{ApplicationLogger, SimpleAppLogger}


object Application extends ApplicationRouting {

  private implicit val system = ActorSystem()
  private implicit val materializer = ActorMaterializer()
  private implicit val executionContext = system.dispatcher

  private val logger: ApplicationLogger = SimpleAppLogger("it.kallsu.scala.template.app.Application")

  def main(args: Array[String]): Unit = {

    // read properties here : use TypeSafe Config

    // log the starting of application
    logger.debug("Start endpoint.")

    // build the server endpoint
    val bindingFuture = Http().bindAndHandle(allRoutes, interface = "localhost", port = 8080)

    // start and stop
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
