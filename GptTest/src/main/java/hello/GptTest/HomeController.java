package hello.GptTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/chat")
    public String showVuePage() {
        return "/index.html";
    }
}
