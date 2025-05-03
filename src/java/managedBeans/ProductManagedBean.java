package managedBeans;

import entities.Category;
import entities.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import sessionBeans.ProductSessionBean;


@Named(value = "productManagedBean")
@SessionScoped
public class ProductManagedBean implements Serializable{
    private Product product;
    private Short categoryId;
    // αυτόματη λήψη αντικειμένου όταν χρειάζεται.
    // Το τρέχον αντικείμενο του managed bean, θα καλεί τη μέθοδο findProducts() 
    // ενός αντικειμένου της κλάσης ProductSessionBean.
    // Για να συμβεί αυτό, χρειάζεται ο managed bean να -
    // έχει μια αναφορά σε αντικείμενο του session bean ProductSessionBean.
    @EJB private ProductSessionBean productSessionBean;
    private List<Product> products;
    
    public String createProduct()
    {
        Category category = new Category();
        category.setId(categoryId);
        product.setCategory(category);
        
        productSessionBean.persistProduct(product);
        product = null;
        categoryId = null;
        return "productCatalog";
    }
    
    public void loadProductsPreRender()
    {
        products = productSessionBean.findProducts();
    }
    
    public List<Product> getProducts()
    {
        // return productSessionBean.findProducts(); μεταφέρθηκε στην loadProductsPreRender()
        return products;
    }
    
    public String prepareCreateProduct(){
        product = new Product();
        categoryId = null;
        
        return "cruProduct";
    }
    
    // προσβάσιμο entity προϊόντος για ανάγνωση από τη σελίδα δημιουργίας προϊόντος
    public Product getProduct(){
        return product;
    }

   
    public Short getCategoryId() {
        return categoryId;
    }
    
    
    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }
}
