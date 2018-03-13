
package week6.burtsbeans.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import static javax.management.Query.value;
import week6.burtsbeans.model.ShoppingCart;
import week6.burtsbeans.model.ShoppingCartService;

/**
 *
 * @author User
 */
@Named(value = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {

    private final ShoppingCartService shoppingCartService;
    @ManagedProperty(name="shoppingCart", value="")
    private ShoppingCart shoppingCart;
    @ManagedProperty(name="cartTotal", value="")
    private double cartTotal;
    /**
     * Creates a new instance of ShoppingCartBean
     */
    
    public ShoppingCartBean() {
        shoppingCartService = new ShoppingCartService();
        setShoppingCart(shoppingCartService.getCart());
    }
    
    public ShoppingCart getShoppingCart(){
        return shoppingCart;
    }
    
    public double getCartTotal(){
        return cartTotal;
    }
    
    public void setShoppingCart(ShoppingCart shoppingCart){
        if(shoppingCart != null){
            this.shoppingCart = shoppingCart;
            cartTotal=0;
        }
    }
    
    public String shoppingCart(){
        shoppingCart = shoppingCartService.getCart();
        return "shoppingCart";
    }
    
}
