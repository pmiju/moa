package moacloth.moashop.controller.admin;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginForm {
    @NotEmpty(message = "사업자아이디는 필수입니다.")
    private String admin_id;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String admin_pw;
}
