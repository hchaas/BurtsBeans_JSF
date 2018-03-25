
package week6.burtsbeans.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import static javax.management.Query.value;
import week6.burtsbeans.model.ShoppingCart;
import week6.burtsbeans.model.ShoppingCartService;
import week6.burtsbeans.model.Product;

@Named(value = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {

    private final String sessionId;
    private final ShoppingCart cart;
    private final ShoppingCartService cartService = new ShoppingCartService();
    
    public ShoppingCartBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        sessionId = facesContext.getExternalContext().getSessionId(true);
        
        cart = cartService.getContents(sessionId);
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
