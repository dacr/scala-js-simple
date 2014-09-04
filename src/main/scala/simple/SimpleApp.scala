package simple

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import scala.scalajs.js.annotation.JSExport
import org.scalajs.jquery.jQuery
import org.scalajs.jquery.JQueryEventObject
import scala.scalajs.js.Dynamic.{ global => g }

object SimpleApp extends JSApp {

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
  var cx=100
  def animate(grc:org.scalajs.jquery.JQuery) {
    println(grc.attr("cx"))
    //val cx = grc.attr("cx").toInt + inc
    cx = cx + inc
    if (cx < 60) inc = 1
    if (cx > 400) inc = -1
    grc.attr("cx", cx)
  }

  def setupUI(): Unit = {
    jQuery("#click-me-button").click(addClickedMessage _)
    jQuery("body").append("<p>Hello World</p>")

    document.defaultView.setInterval(() => animate(jQuery("GR-C")), 500)

    jQuery("#GR-C").hover(in _, out _)
  }

  def main(): Unit = {
    jQuery(setupUI _)
    println("done")
  }

}
