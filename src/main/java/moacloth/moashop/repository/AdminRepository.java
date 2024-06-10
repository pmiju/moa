package moacloth.moashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import moacloth.moashop.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Admin admin) {
        em.persist(admin);
    }

    public Admin findOne(String admin_id) {
        return em.find(Admin.class, admin_id);
    }

    public List<Admin> findById(String admin_id) {
        return em.createQuery("select a from Admin a where a.admin_id = :admin_id",
                        Admin.class)
                .setParameter("admin_id", admin_id)
                .getResultList();
    }
}
