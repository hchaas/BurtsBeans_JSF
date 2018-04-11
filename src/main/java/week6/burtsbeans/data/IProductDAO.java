
package week6.burtsbeans.data;

import week6.burtsbeans.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDAO extends JpaRepository<Product, String>{
    
}
