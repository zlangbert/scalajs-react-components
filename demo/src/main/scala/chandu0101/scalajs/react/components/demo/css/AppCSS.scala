package chandu0101.scalajs.react.components.demo.css

import chandu0101.scalajs.react.components.demo.components.materialui._
import chandu0101.scalajs.react.components.demo.components.{LeftNav, LeftNavPage}
import chandu0101.scalajs.react.components.listviews.ReactListView
import chandu0101.scalajs.react.components.pagers.Pager
import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import chandu0101.scalajs.react.components.tables.ReactTable

import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.GlobalRegistry

object AppCSS {

  def load = {
    GlobalRegistry.register(LeftNav.Style,
      LeftNavPage.Style,
      MuiButtonsDemo.Style,
      MuiPaperDemo.Style,
      MuiSwitchesDemo.Style,
      MuiMenuDemo.Style,
      MobileTearSheet.Style,
      ReactTable.DefaultStyle,
      ReactListView.DefaultStyle,
      ReactSearchBox.DefaultStyle,
      Pager.DefaultStyle,
      MuiTabsDemo.Style)
    GlobalRegistry.addToDocumentOnRegistration()
  }
}
