package moacloth.moashop.controller;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import moacloth.moashop.domain.Admin;

import java.sql.Blob;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {
    @NotEmpty(message = "상품이미지는 필수입니다.")
    private Blob product_img;

    @NotEmpty(message = "상품이름은 필수입니다.")
    private String product_name;

    @NotEmpty(message = "상품가격은 필수입니다.")
    private int product_price;

    @NotEmpty(message = "상품설명은 필수입니다.")
    private String product_ex;
}
