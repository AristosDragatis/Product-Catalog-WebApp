
package managedBeans;

import entities.Category;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import sessionBeans.CategorySB;


@Named(value = "categoryMenu")
@ApplicationScoped
public class CategoryMenu {

    
    public CategoryMenu() {
    }
    
    List<Category> categories;
    @EJB private CategorySB categorySB;
    
    @PostConstruct
    public void loadCategories()
    {
        categories = categorySB.findCategories();
    }
    
    public List<Category> getCategories()
    {
        return categories;
    }
}
