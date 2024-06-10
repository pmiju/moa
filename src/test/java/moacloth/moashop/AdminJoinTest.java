package moacloth.moashop;

import moacloth.moashop.domain.Admin;
import moacloth.moashop.repository.AdminRepository;
import moacloth.moashop.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AdminJoinTest {
    @Autowired
    static AdminService adminService;
    @Autowired
    static AdminRepository adminRepository;

    @Test
    public static void main(String[] args) {
        //given
        //Admin admin = new Admin();
        //admin.Admin("test", "Test", "test", "test", "test", "Test");

        //when
        //Admin savedAdmin = adminService.join(admin);

        //then
        //Assertions.
    }
}
