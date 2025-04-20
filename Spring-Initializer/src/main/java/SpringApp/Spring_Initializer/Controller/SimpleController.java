package SpringApp.Spring_Initializer.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SimpleController {
    private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        logger.info("Home page accessed - Application: {}", appName);
        model.addAttribute("appName", appName);
        return "home";
    }
}