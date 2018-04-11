package week6.burtsbeans.service;

import week6.burtsbeans.data.IProductDAO;
import java.util.List;
import week6.burtsbeans.model.Product;
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
       
        return productDAO.findOne(id);
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
}
