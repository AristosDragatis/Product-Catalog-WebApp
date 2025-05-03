
package sessionBeans;

import entities.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductSessionBean {

    @PersistenceContext(unitName = "ols_dragatisPU")
    private EntityManager em;

    public void persistProduct(Product product)
    {
        em.persist(product);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<Product> findProducts(){
        return em.createNamedQuery("Product.findAll").getResultList();
    }
}
