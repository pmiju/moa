package moacloth.moashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminForm {
    @NotEmpty(message = "사업자아이디는 필수입니다.")
    private String admin_id;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String admin_pw;

    @NotEmpty(message = "사업자 번호는 필수입니다.")
    private String admin_num;

    @NotEmpty(message = "사업자 이름은 필수입니다.")
    private String admin_name;

    @NotEmpty(message = "번호는 필수입니다.")
    private String admin_phone;

    @NotEmpty(message = "이메일은 필수입니다.")
    private String admin_email;


}
