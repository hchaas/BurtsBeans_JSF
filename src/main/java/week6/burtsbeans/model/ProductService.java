package week6.burtsbeans.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import week6.burtsbeans.data.ProductDAO;

//product id, name, description, quantity
public class ProductService {

    public Product getProduct(String id) {
       //TODO
        return null;
    }

    public List<Product> findProducts(String search) throws Exception {
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.getProducts();
        List<Product> returnList = new ArrayList<>();
       
        for (Product product : productList) {
            if (product.getProductName().startsWith(search)
                    || product.getProductName().contains(search)
                    || product.getProductDescription().contains(search)) {
                returnList.add(product);
            }
        }
        return returnList;
    }

    public List<Product> getAllProducts() throws Exception {
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.getProducts();
        
        return productList;
    }
}
