
package burtsbeans.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {
    
    @Id
    @GeneratedValue (generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String productID;
    
    @Column(name="productname")
//    private String productID;
    private String productName;
    
    @Column(name="productdescription")
    private String productDescription;
    
    @Column(name="priceperpound")
    private int pricePerPound;
    
    public Product(){
        
    }

    public Product(String productName, String productDescription, int pricePerPound) {
        this.setProductName(productName);
        this.setProductDescription(productDescription);
//        this.setProductQuantity(productQuantity);
        this.setPricePerPound(pricePerPound);
    }
    
    public void setProductID(String productID) throws IllegalArgumentException{
        if (productID == null || productID.isEmpty()){
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        this.productID = productID;
    }

    public void setProductName(String productName) throws IllegalArgumentException{
        if(productName == null || productName.isEmpty()){
            throw new IllegalArgumentException("Product Name cannot be null or empty.");
        }
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) throws IllegalArgumentException{
        if(productDescription == null || productDescription.isEmpty()){
            throw new IllegalArgumentException("Product description cannot be null or empty.");
        }
        this.productDescription = productDescription;
    }

//    public final void setProductQuantity(int productQuantity) throws IllegalArgumentException{
//        if(productQuantity < 0){
//            throw new IllegalArgumentException("Product quantity cannot be less than zero.");
//        }
//        this.productQuantity = productQuantity;
//    }

    public void setPricePerPound(int pricePerPound) {
        if(pricePerPound < 0){
            throw new IllegalArgumentException("Product price cannot be less than zero.");
        }
        this.pricePerPound = pricePerPound;
    }

    public int getPricePerPound() {
        return pricePerPound;
    }
    
    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

//    public final int getProductQuantity() {
//        return productQuantity;
//    }
    
    
}
