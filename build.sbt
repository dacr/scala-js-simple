scalaJSSettings

name := "scala-js-simple"

scalaVersion := "2.11.2"

libraryDependencies += "org.scala-lang.modules.scalajs" %%% "scalajs-dom" % "0.6"

libraryDependencies += "org.scala-lang.modules.scalajs" %%% "scalajs-jquery" % "0.6"

skip in ScalaJSKeys.packageJSDependencies := false

