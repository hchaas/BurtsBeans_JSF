package week6.burtsbeans.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {


    private final List<Product> contents = new ArrayList<>();
    
    public List<Product> getContents(){
        return contents;
    }

    public int getItemsInCart(){
        return contents.size();
    }

    public void add(Product product){
        contents.add(product);
    }

    public void remove(Product product){
        contents.remove(product);
    }

    public void removeAll(){
        contents.clear();
    }
}
