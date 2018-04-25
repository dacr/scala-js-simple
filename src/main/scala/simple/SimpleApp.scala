package simple

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import org.querki.jquery._


import scala.scalajs.js
import org.singlespaced.d3js._
import org.singlespaced.d3js.Ops._

object SimpleApp extends JSApp {

  def test(): Unit = {
    /**
     * Adapted from http://thecodingtutorials.blogspot.ch/2012/07/introduction-to-d3.html
     */
    val graphHeight = 200

    //The width of each bar.
    val barWidth = 40

    //The distance between each bar.
    val barSeparation = 10

    //The maximum value of the data.
    val maxData = 50

    //The actual horizontal distance from drawing one bar rectangle to drawing the next.
    val horizontalBarDistance = barWidth + barSeparation

    //The value to multiply each bar's value by to get its height.
    val barHeightMultiplier = graphHeight / maxData;

    //Color for start
    val c = d3.rgb("DarkSlateBlue")

    val rectXFun = (d: Int, i: Int) => i * horizontalBarDistance
    val rectYFun = (d: Int) => graphHeight - d * barHeightMultiplier
    val rectHeightFun = (d: Int) => d * barHeightMultiplier
    val rectColorFun = (d: Int, i: Int) => c.brighter(i * 0.5).toString

    val svg = d3.select("#playground").append("svg").attr("width", "100%").attr("height", "200px")
    val sel = svg.selectAll("rect").data(js.Array(8, 22, 31, 36, 48, 17, 25))
    sel.enter()
      .append("rect")
      .attr("x", rectXFun)
      .attr("y", rectYFun)
      .attr("width", barWidth)
      .attr("height", rectHeightFun)
      .style("fill", rectColorFun)
  }

  
  
  
  //@JSExport
  def addClickedMessage(): Unit = {
    $("body").append("You clicked the button!<br/>")
    println("ici")
  }

  def in(evt: JQueryEventObject): scala.scalajs.js.Any = {
    //jQuery("body").append(s"IN<br/>")
    $(evt.target)
      .attr("fill", "blue")
      .attr("r", 50)
      .attr("stroke-width", "8")
  }

  def out(evt: JQueryEventObject): scala.scalajs.js.Any = {
    //jQuery("body").append(s"OUT<br/>")
    $(evt.target)
      .attr("fill", "yellow")
      .attr("r", 40)
      .attr("stroke-width", "4")
  }


  val speed = 10
  var inc = speed
  //var cx=100
  def animate(grc: JQuery) {
    //println(grc.attr("cx"))
    //val cx = grc.attr("cx").toInt + inc
    var cx = grc.attr("cx").get.toInt
    cx = cx + inc
    if (cx < 60) inc = speed
    if (cx > 400) inc = -speed
    grc.attr("cx", cx)
  }

  def setupUI(): Unit = {
    $("#click-me-button").click(addClickedMessage _)
    $("body").append("<p>Hello World</p>")

    scala.scalajs.js.timers.setInterval(25) {
      animate( $("#GR-C") )
    }

    $("#GR-C").hover(in _, out _)
  }

  def main(): Unit = {
    //$(setupUI _)
    setupUI()
    test()
    println("done")
  }

}
