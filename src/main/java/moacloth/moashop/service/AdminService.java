package moacloth.moashop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moacloth.moashop.controller.admin.AdminForm;
import moacloth.moashop.controller.admin.AdminLoginForm;
import moacloth.moashop.domain.Admin;
import moacloth.moashop.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class AdminService{
    @Autowired
    AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public String join(Admin admin) {
        Admin buildadmin = Admin.builder()
                .admin_id(admin.getAdmin_id())
                .admin_pw(passwordEncoder.encode(admin.getAdmin_pw()))
                .admin_num(admin.getAdmin_num())
                .admin_name(admin.getAdmin_name())
                .admin_phone(admin.getAdmin_phone())
                .admin_email(admin.getAdmin_email())
                .build();

        validateDuplicateAdmin(buildadmin);
        adminRepository.save(buildadmin);
        return admin.getAdmin_id();
    }

    @Transactional
    public Admin login(AdminLoginForm adminLoginForm) {
        Admin loginAdmin = Admin.builder()
                .admin_id(adminLoginForm.getAdmin_id())
                .admin_pw(adminLoginForm.getAdmin_pw())
                .build();

        Optional<Admin> loginbyAdmin = adminRepository.findByAdmin(loginAdmin.getAdmin_id(), loginAdmin.getAdmin_pw());
        return loginbyAdmin.get();
    }

    private void validateDuplicateAdmin(Admin admin) {
        log.info(this.getClass().getName() + "중복체크로직실행");
        log.info(admin.getAdmin_id());

        List<Admin> findAdmin = adminRepository.findById(admin.getAdmin_id());

        log.info("로직 후 아이디 = ", findAdmin);

        if(!findAdmin.isEmpty()) {
            if (!findAdmin.isEmpty()) {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            }
        }
    }

    public int checkId(String admin_id) {
        List<Admin> findAdmin = adminRepository.findById(admin_id);
        if (findAdmin.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }

    public int checkName(String admin_name) {
        List<Admin> findbyName = adminRepository.findByName(admin_name);
        if (findbyName.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }
}
