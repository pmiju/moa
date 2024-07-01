package moacloth.moashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import moacloth.moashop.domain.Admin;
import moacloth.moashop.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Product product) {
        em.persist(product);
    }
}
