package moacloth.moashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Entity
@NoArgsConstructor
@Table(name="admintbl")
public class Admin {
    @Id
    @Column(name="admin_id", length=500, nullable = false)
    private String admin_id;

    @Column(name="admin_pw", length=500, nullable = false)
    private String admin_pw;

    @Column(name="admin_num", length=500, nullable = false)
    private String admin_num;

    @Column(name = "admin_name", length=500, nullable = false)
    private String admin_name;

    @Column(name = "admin_phone", length=500, nullable = false)
    private String admin_phone;

    @Column(name = "admin_email", length=500, nullable = false)
    private String admin_email;

    @Builder
    public Admin(String admin_id, String admin_pw, String admin_num, String admin_name, String admin_phone, String admin_email) {
        this.admin_id = admin_id;
        this.admin_pw = admin_pw;
        this.admin_num = admin_num;
        this.admin_name = admin_name;
        this.admin_phone = admin_phone;
        this.admin_email = admin_email;
    }

    @Builder
    public Admin(String admin_id, String admin_pw) {
        this.admin_id = admin_id;
        this.admin_pw = admin_pw;
    }


    public Admin encodePassword(PasswordEncoder passwordEncoder) {
        this.admin_pw = passwordEncoder.encode(this.admin_pw);
        return this;
    }
}
