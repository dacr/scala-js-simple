package simple

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import scala.scalajs.js.annotation.JSExport
import org.scalajs.jquery.jQuery
import org.scalajs.jquery.JQueryEventObject

object SimpleApp extends JSApp {

  //@JSExport
  def addClickedMessage(): Unit = {
    jQuery("body").append("You clicked the button!<br/>")
    println("ici")
  }

  def in(evt:JQueryEventObject):scala.scalajs.js.Any = {
    //jQuery("body").append(s"IN<br/>")
    jQuery(evt.target)
       .attr("fill","blue")
       .attr("r", 50)
       .attr("stroke-width", "8")
    
  }

  def out(evt:JQueryEventObject):scala.scalajs.js.Any = {
    //jQuery("body").append(s"OUT<br/>")
    jQuery(evt.target)
       .attr("fill","yellow")
       .attr("r", 40)
       .attr("stroke-width", "4")
  }


  def setupUI(): Unit = {
    jQuery("#click-me-button").click(addClickedMessage _)
    jQuery("body").append("<p>Hello World</p>")
    
    jQuery("#GR-C").hover(in _, out _)
  }

  def main(): Unit = {
    jQuery(setupUI _)
    println("done")
  }
  
}
