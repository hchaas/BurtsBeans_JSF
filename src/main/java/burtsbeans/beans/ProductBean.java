package burtsbeans.beans;


import burtsbeans.model.Product;
import burtsbeans.service.ProductService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("productBean")
@Scope("session")
public class ProductBean implements Serializable {
    @Autowired
    private ProductService productService;
    
    private String search;
    private Product product;
    private List<Product> productList;

   public ProductBean(){
       
   }
    public ProductBean(ProductService productService) throws Exception {
        this.productService = productService;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductService getProductService() {
        return productService;
    }

    public Product getProduct() {
        return product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String allProducts() throws Exception {
        productList = productService.getAllProducts();
        return "productList";
    }

    public void setSearchString(String search){
        if(search != null){
            this.search = search;
        }
    }
    
    public String getSearchString(){
        return search;
    }
    
    public String searchProducts() throws Exception{
        productList = productService.findProducts(search);
        return "productList";
    }
    
    public void productDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("productDetail.xhtml?id-" + product.getProductID());
        } catch (IOException ex) {
            FacesMessage msg = new FacesMessage("IOException", product.getProductID());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
