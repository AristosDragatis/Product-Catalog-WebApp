
package sessionBeans;

import entities.Category;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class CategorySB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "ols_dragatisPU")
    private EntityManager em;
    
    public List<Category> findCategories(){
        return em.createNamedQuery("Category.findAll").getResultList();
    }
}
