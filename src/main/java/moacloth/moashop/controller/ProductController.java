package moacloth.moashop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    @GetMapping(value = "/confirmProduct")
    public String createConfirm(Model model) {
        return "admin/confirmProduct";
    }

    @GetMapping(value = "/add")
    public String createAdd(Model model) {
        return "admin/add";
    }
}
