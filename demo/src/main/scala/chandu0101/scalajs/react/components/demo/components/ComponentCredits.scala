package chandu0101.scalajs.react.components.demo.components

import chandu0101.scalajs.react.components.models.Github
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.ext.Ajax

import scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow
import scala.scalajs.js
import scala.scalajs.js.{Date, JSON}

/**
 * Created by chandrasekharkode .
 */
object ComponentCredits {


  case class State(users : List[Github])

  class Backend(t: BackendScope[Props, State]) {

  }

  val component = ReactComponentB[Props]("ComponentCredits")
    .initialState(State(List()))
    .backend(new Backend(_))
    .render((P,S,B) => {
      if(S.users.isEmpty)<.div("Loading Credits ...")
      else
      <.div(
        <.h4("Author : "),
        GithubUser(S.users.head),
        <.h4("Contributors : "),
       <.div(^.marginRight := "10px")(S.users.tail.map(u => GithubUser(user = u , key = u.login)))
       )
    })
    .componentDidMount(scope => {
        val url = s"https://api.github.com/repos/chandu0101/scalajs-react-components/commits?path=${scope.props.filePath}"
         Ajax.get(url).onSuccess {
          case xhr => {
               if(xhr.status == 200) {
                  val rawUsers = JSON.parse(xhr.responseText).asInstanceOf[js.Array[js.Dynamic]]
                  val users = rawUsers.map(u => Github(login = u.author.login.toString,html_url = u.author.html_url.toString , avatar_url = u.author.avatar_url.toString,time = new Date(u.commit.author.date.toString).getTime()))
                    .toList.groupBy(_.login).map {
                    case (id,objlist) => objlist.minBy(_.time)
                  }.toSet.toList
                  scope.modState(_.copy(users= users.sortBy(_.time)))
               }
          }
        }
    })
    .build


  case class Props(filePath : String)

  def apply(filePath : String,ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(filePath))
}
