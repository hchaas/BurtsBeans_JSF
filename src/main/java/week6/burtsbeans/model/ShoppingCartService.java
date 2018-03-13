package week6.burtsbeans.model;

import java.util.LinkedHashMap;

public class ShoppingCartService {    
    
    private ShoppingCart cart; 

    public ShoppingCartService() {
        cart.addToCart(new Product("1", "Light Roast", "Light roasted coffee", 1, 8));
        cart.addToCart(new Product("2", "Dark Roast", "Darkly roasted coffee", 1, 9));
    }

    public ShoppingCart getCart() {
        return cart;
    }

}
