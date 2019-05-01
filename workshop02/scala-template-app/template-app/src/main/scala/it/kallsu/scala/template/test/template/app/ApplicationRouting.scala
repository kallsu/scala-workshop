package it.kallsu.scala.template.test.template.app

import akka.http.scaladsl.server.Directives._

trait ApplicationRouting {

  lazy val userRoutes = path("login") {
    post {
      complete("OK")
    }
  } ~ path("logout") {
    post {
      complete("ok")
    }
  } ~ pathPrefix("user") {
    path(Segment) {
      userToken =>
        get {
          complete("Ok")
        }
    }
  }

  lazy val productRoute = pathPrefix("product") {
    path(Segment / "get") {
      id =>
        get {
          complete("Get product by Id")
        }
    } ~
      path("create") {
        post {
          complete("Create new product")
        }
      } ~
      path("update") {
        put {
          complete("Update existing product")
        }
        delete {
          complete("Delete existing product")
        }
      }
  }

  lazy val allRoutes = userRoutes ~ productRoute
}
