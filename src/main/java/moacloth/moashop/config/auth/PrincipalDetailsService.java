package moacloth.moashop.config.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moacloth.moashop.domain.Admin;
import moacloth.moashop.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String admin_id) throws UsernameNotFoundException {
        log.info("되긴하냐?");
        log.info(admin_id);
        Admin result = adminRepository.login(admin_id);
        if (result == null) {
            throw new UsernameNotFoundException("없는 회원입니다.");
        }
        return new PrincipalDetails(result);
/*        return User.builder()
                .username(result.getAdmin_id())
                .password(result.getAdmin_pw())
                .build();*/
    }

}
