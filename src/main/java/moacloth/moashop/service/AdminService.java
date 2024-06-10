package moacloth.moashop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moacloth.moashop.controller.AdminForm;
import moacloth.moashop.domain.Admin;
import moacloth.moashop.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Transactional
    public String join(AdminForm admin) {
        Admin buildadmin = Admin.builder()
                .admin_id(admin.getAdmin_id())
                .admin_pw(admin.getAdmin_pw())
                .admin_num(admin.getAdmin_num())
                .admin_name(admin.getAdmin_name())
                .admin_phone(admin.getAdmin_phone())
                .admin_email(admin.getAdmin_email())
                .build();


        validateDuplicateAdmin(buildadmin);
        adminRepository.save(buildadmin);
        return admin.getAdmin_id();
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
}
