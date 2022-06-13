package evgenulianov.springjdbc.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Locale;

@Getter
@Repository
public class MyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getProducts(String name) {
        Query query = entityManager.createQuery(
                "select distinct o.productName from Orders o where lower(o.customer.name) = :name",
                String.class);
        query.setParameter("name", name.toLowerCase(Locale.ROOT));//
        return query.getResultList();
    }

}