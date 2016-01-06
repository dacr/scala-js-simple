enablePlugins(ScalaJSPlugin)

name := "scala-js-simple"

scalaVersion := "2.11.7"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.8.0"

skip in packageJSDependencies := false


