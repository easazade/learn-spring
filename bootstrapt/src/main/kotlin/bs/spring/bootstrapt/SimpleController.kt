package bs.spring.bootstrapt

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

import org.springframework.web.bind.annotation.GetMapping

@Controller
class SimpleController {

  @Value("\${spring.application.name}")

  lateinit var appName: String

  @GetMapping("/")
  fun homePage(model: Model): String {
    model.addAttribute("appName", appName)
    return "home"
  }
}
