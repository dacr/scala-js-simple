enablePlugins(ScalaJSPlugin)

name := "scala-js-simple"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "be.doeraene" %%% "scalajs-jquery" % "0.8.0",
  "org.singlespaced" %%% "scalajs-d3" % "0.1.2"
)

skip in packageJSDependencies := false


