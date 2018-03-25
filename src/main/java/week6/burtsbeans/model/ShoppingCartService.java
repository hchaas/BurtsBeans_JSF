package week6.burtsbeans.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCartService {    

    private static final Map<String, ShoppingCart> contents = new HashMap<>();

    public ShoppingCart getContents(String sessionId){
        //if shopping cart doesn't exist, it creates one
        ShoppingCart cart = contents.computeIfAbsent(sessionId, 
                (String s) -> new ShoppingCart());
        return cart;
    }

    public void update(String sessionId, ShoppingCart cart){
        contents.put(sessionId, cart);
    }

}
