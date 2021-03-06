package chandu0101.scalajs.react.components.demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scala.scalajs.js
import scala.scalajs.js.undefined
import scala.scalajs.js.UndefOr
import scalacss.Defaults._
import scalacss.ScalaCssReact._

/**
 * Created by chandrasekharkode .
 */
object InfoTemplate {

   object Style extends StyleSheet.Inline {
       import dsl._
       val content = style(textAlign.center,
         fontSize(30.px),
         paddingTop(40.px))
     }



  val component = ReactComponentB[Props]("InfoTemplate")
    .render((P,C) => {
      <.div(^.cls := "info-template")(
        <.div(^.cls := "component-info")(C),
        P.browsersTested.nonEmpty ?= <.div(^.marginTop := "10px")(
           <.h4("Tested Browsers List :"),
           <.ul(^.marginLeft := "50px")(P.browsersTested.map(s => <.li(s)))
         ),
        <.div(^.marginTop := "10px")(
           ComponentCredits(filePath = s"core/src/main/scala/chandu0101/scalajs/react/components/${P.componentFilePath}")
         )
       )
    }).build


  case class Props(browsersTested : List[String] ,componentFilePath : String)

  def apply(componentFilePath : String,browsersTested : List[String] = List() , ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactNode*) = component.set(key, ref)(Props(browsersTested,componentFilePath),children)

}
