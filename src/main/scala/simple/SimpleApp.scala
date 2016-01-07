package simple

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import scala.scalajs.js.annotation.JSExport
import org.scalajs.jquery.jQuery
import org.scalajs.jquery.JQueryEventObject
import scala.scalajs.js.Dynamic.{ global => g }

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
    jQuery("body").append("You clicked the button!<br/>")
    println("ici")
  }

  def in(evt: JQueryEventObject): scala.scalajs.js.Any = {
    //jQuery("body").append(s"IN<br/>")
    jQuery(evt.target)
      .attr("fill", "blue")
      .attr("r", 50)
      .attr("stroke-width", "8")
  }

  def out(evt: JQueryEventObject): scala.scalajs.js.Any = {
    //jQuery("body").append(s"OUT<br/>")
    jQuery(evt.target)
      .attr("fill", "yellow")
      .attr("r", 40)
      .attr("stroke-width", "4")
  }

  var inc = 1
  //var cx=100
  def animate(grc: org.scalajs.jquery.JQuery) {
    //println(grc.attr("cx"))
    //val cx = grc.attr("cx").toInt + inc
    var cx = grc.attr("cx").toInt
    cx = cx + inc
    if (cx < 60) inc = 2
    if (cx > 400) inc = -2
    grc.attr("cx", cx)
  }

  def setupUI(): Unit = {
    jQuery("#click-me-button").click(addClickedMessage _)
    jQuery("body").append("<p>Hello World</p>")

    dom.setInterval(() => animate(jQuery("#GR-C")), 25)

    jQuery("#GR-C").hover(in _, out _)
  }

  def main(): Unit = {
    jQuery(setupUI _)
    test()
    println("done")
  }

}
