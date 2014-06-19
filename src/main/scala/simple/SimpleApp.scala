package simple

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import scala.scalajs.js.annotation.JSExport

import org.scalajs.jquery.jQuery

object SimpleApp extends JSApp {

  //@JSExport
  def addClickedMessage(): Unit = {
    jQuery("body").append("You clicked the button!<br/>")
  }

  def setupUI(): Unit = {
    jQuery("#click-me-button").click(addClickedMessage _)
    jQuery("body").append("<p>Hello World</p>")
  }

  def main(): Unit = {
    jQuery(setupUI _)
    println("done")
  }
}
