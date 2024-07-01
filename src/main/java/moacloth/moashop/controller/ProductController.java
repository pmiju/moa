package moacloth.moashop.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moacloth.moashop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/confirmProduct")
    public String createConfirm(Model model) {
        return "admin/confirmProduct";
    }

    @GetMapping(value = "/add")
    public String createAdd(Model model) {
        model.addAttribute("addForm", new ProductForm());
        return "admin/add";
    }

    @PostMapping(value = "/product/add")
    public String productAdd(@Valid ProductForm productForm, BindingResult result) {
        log.info("상품추가");
        if (result.hasErrors()) {
            log.info("추가 실패");
            return "add";
        }

        return "admin/confirmProduct";
    }
}
