package burtsbeans.service;

import burtsbeans.data.dao.IProductDAO;
import java.util.List;
import burtsbeans.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private IProductDAO productDAO;

    public Product getProduct(String id) {
        
        return productDAO.getOne(id);
    }

    public List<Product> findProducts(String search) throws Exception {
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("productname", startsWith().ignoreCase());
        Product product = new Product();
        product.setProductName(search);
        return productDAO.findAll(Example.of(product, matcher));
       
    }

    public List<Product> getAllProducts() throws Exception {
        return productDAO.findAll();
    }
    
    public Product createProduct(Product product){
        return productDAO.save(product);
    }
    
    public Product updateProduct(Product product){
        return productDAO.save(product);
    }
    
    public void deleteProduct(String id){
        productDAO.deleteById(id);
    }
}
