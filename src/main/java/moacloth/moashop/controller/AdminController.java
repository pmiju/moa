package moacloth.moashop.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moacloth.moashop.domain.Admin;
import moacloth.moashop.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/adminJoin")
    public String createFrom(Model model) {
        model.addAttribute("adminForm", new AdminForm());
        return "admin/adminJoin";
    }

    @PostMapping(value="/admin/join")
    public String joinForm(@Valid AdminForm form, BindingResult result) {
        log.info("회원가입 controller 로직 처리 시작");
        if (result.hasErrors()) {
            log.info("실패여");
            log.info("error={}", result);
            return "admin/adminJoin";
        }

        adminService.join(form);
        log.info("사업자 회원가입 완료");
        return "admin/adminLogin";
    }
}
