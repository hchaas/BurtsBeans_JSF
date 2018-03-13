package week6.burtsbeans.model;

import java.util.List;

public class ShoppingCart {

    private final int totalProductCount = 0;
    private final int totalCartCost = 0;
    private List<Product> ProductsInCart;
    
    public final void addToCart(Product product){
        ProductsInCart.add(product);
        this.setTotalProductCount(product.getProductQuantity());
        this.setTotalCartCost(product.getPricePerPound());
    }
    
    public final List<Product> getCart(){
        return ProductsInCart;
    }

    public final void setTotalProductCount(int productCount) {
        productCount += totalProductCount;
    }
    
    public final void setTotalCartCost(int cost){
        cost += totalCartCost;
    }

    public final int getTotalProductCount() {
        return totalProductCount;
    }

    public final int getTotalCartCost() {
        return totalCartCost;
    }
}
