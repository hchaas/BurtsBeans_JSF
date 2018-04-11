
package week6.burtsbeans.beans;

import week6.burtsbeans.model.Product;
import week6.burtsbeans.model.ShoppingCart;
import week6.burtsbeans.service.ShoppingCartService;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "shoppingCartBean")
@Scope("session")
public class ShoppingCartBean implements Serializable {

    private final String sessionId;
    private final ShoppingCart cart;
    private final ShoppingCartService cartService;
    
    @Autowired
    public ShoppingCartBean(ShoppingCartService cartService) {
        this.cartService = cartService;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        sessionId = facesContext.getExternalContext().getSessionId(true);
        
        cart = cartService.getContents(sessionId);
    }

    
    public ShoppingCart getCart(){
        return cart;
    }
    
    public int getItemsInCart(){
        return cart.getItemsInCart();
    }

    public void addToCart(Product product){
        cart.add(product);
        cartService.update(sessionId, cart);
    }

    public void deleteFromCart(Product product){
        cart.remove(product);
    }
    
}
