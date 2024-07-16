package moacloth.moashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import moacloth.moashop.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminRepository {
    @PersistenceContext
    private EntityManager em;

    private final PasswordEncoder passwordEncoder;

    public void save(Admin admin) {
        em.persist(admin);
    }

    public Admin findOne(String admin_id) {

        return em.find(Admin.class, admin_id);
    }
    public Admin login(String admin_id) {
        return em.createQuery("select a from Admin a where a.admin_id = :admin_id",
                        Admin.class)
                .setParameter("admin_id", admin_id)
                .getSingleResult();
    }

    public List<Admin> findById(String admin_id) {
        return em.createQuery("select a from Admin a where a.admin_id = :admin_id",
                        Admin.class)
                .setParameter("admin_id", admin_id)
                .getResultList();
    }

    public List<Admin> findByName(String admin_name) {
        return em.createQuery("select a from Admin a where a.admin_name = :admin_name",
                        Admin.class)
                .setParameter("admin_name", admin_name)
                .getResultList();
    }

    public Optional<Admin> findByAdmin(String admin_id, String admin_pw) {
        return em.createQuery("select a from Admin a where a.admin_id = :admin_id and a.admin_pw = :admin_pw",
                        Admin.class)
                .setParameter("admin_id", admin_id)
                .setParameter("admin_pw", admin_pw)
                .getResultList()
                .stream().findAny();
    }

/*    public Optional<Admin> login(String admin_id, String admin_pw) {
        Admin findAdmin = em.createQuery("select a from Admin a where a.admin_id = :admin_id",
                        Admin.class)
                .setParameter("admin_id", admin_id)
                .getSingleResult();
        if(passwordEncoder.matches(admin_pw, findAdmin.getAdmin_pw()) == true){
            return Optional.of(findAdmin);
        } else {
            return Optional.empty();
        }
    }*/

}
