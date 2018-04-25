enablePlugins(ScalaJSPlugin)

name := "scala-js-simple"

scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "org.querki" %%% "jquery-facade" % "1.2",
  "org.singlespaced" %%% "scalajs-d3" % "0.3.4",
  "org.scala-js" %%% "scalajs-dom" % "0.9.5"
)

skip in packageJSDependencies := false


jsDependencies +=
  "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"
