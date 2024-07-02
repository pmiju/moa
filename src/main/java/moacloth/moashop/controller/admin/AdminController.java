package moacloth.moashop.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moacloth.moashop.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/checkAdminId")
    @ResponseBody
    public int checkAdminId(@RequestParam("admin_id") String admin_id) {
        int result = adminService.checkId(admin_id);
        return result;
    }

    @RequestMapping(value = "/checkAdminName")
    @ResponseBody
    public int checkAdminName(@RequestParam("admin_name") String admin_name) {
        int nameresult = adminService.checkName(admin_name);
        return nameresult;
    }

    @PostMapping(value = "/admin/join")
    public String joinForm(@Valid AdminForm adminForm, BindingResult result) {
        log.info("회원가입 controller 로직 처리 시작");
        if (result.hasErrors()) {
            log.info("실패여");
            log.info("error={}", result);
            return "admin/adminJoin";
        }

        adminService.join(adminForm);
        log.info("사업자 회원가입 완료");
        return "redirect:/adminLogin";
    }

    /* 사업자 로그인 */
    @GetMapping(value = "/adminLogin")
    public String createLogin(Model model) {
        model.addAttribute("adminLoginForm", new AdminLoginForm());
        return "admin/adminLogin";
    }

    @PostMapping(value = "/admin/login")
    public String loginForm(@Valid AdminLoginForm adminLoginForm, BindingResult result) {
        log.info("로그인 controller 로직 처리 시작");
        if (result.hasErrors()) {
            log.info("실패");
            log.info("error = {}", result);
            return "admin/adminLogin";
        }

        adminService.login(adminLoginForm);
        log.info("로그인 성공!");
        return "redirect:/confirmProduct";
    }
}
