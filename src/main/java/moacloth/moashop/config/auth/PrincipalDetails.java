package moacloth.moashop.config.auth;

import lombok.Data;
import moacloth.moashop.domain.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails {
    private Admin admin;
    private Map<String, Object> attributes;

    public PrincipalDetails(Admin admin) {
        this.admin = admin;
    }

    public PrincipalDetails(Admin admin, Map<String, Object> attributes) {
        this.admin = admin;
        this.attributes= attributes;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return null;
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return admin.getAdmin_pw();
    }

    @Override
    public String getUsername() {
        return admin.getAdmin_id();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

/*    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }*/
}