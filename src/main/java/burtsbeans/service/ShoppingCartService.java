package burtsbeans.service;

import java.util.HashMap;
import java.util.Map;
import burtsbeans.model.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
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
    
    public void delete(String sessionId){
        contents.remove(sessionId);
    }

}
