package week6.burtsbeans.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//product id, name, description, quantity
public class ProductService {

    private List<Product> productList = Arrays.asList(
            new Product("1", "Light Roast", "Our light house blend offers a smooth, enchanting experience.", 1, 12),
            new Product("2", "Breakfast Blend", "Wake up with a crowd-pleasing favorite breakfast bean blend.", 1, 12),
            new Product("3", "Dark Roast", "The dark roast is Burt's specialty.", 1, 14)
    );

    public Product getProduct(String id) {
        Product theProduct = null;

        for (Product product : productList) {
            if (product.getProductID().equals(id)) {
                theProduct = product;
            }
            
        }
        return theProduct;
    }

    public List<Product> findProducts(String search) {
        List<Product> returnProduct = new ArrayList<Product>();
        for (Product product : productList) {
            if (product.getProductName().startsWith(search)
                    || product.getProductName().contains(search)
                    || product.getProductDescription().contains(search)) {
                returnProduct.add(product);
            }
        }
        return returnProduct;
    }

    public List<Product> getAllProducts() {
        return productList;
    }
}
