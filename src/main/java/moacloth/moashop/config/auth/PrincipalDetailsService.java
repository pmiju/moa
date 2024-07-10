package moacloth.moashop.config.auth;

import moacloth.moashop.domain.Admin;
import moacloth.moashop.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String admin_id) throws UsernameNotFoundException {
        Admin adminEntity = adminRepository.findOne(admin_id);
        if (adminEntity != null) {
            return new PrincipalDetails(adminEntity);
        }
        return null;
    }
}
