package moacloth.moashop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    @RequestMapping("/")
    public String splash() {
        return "splash";
    }

    @RequestMapping("/main")
    public String main() {
        log.info("main controller");
        return "main";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin() {
        log.info("main controller");
        return "admin/adminLogin";
    }

/*    @RequestMapping("/adminJoin")
    public String adminJoin() {
        log.info("main controller");
        return "admin/adminJoin";
    }*/
}

