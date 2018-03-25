package week6.burtsbeans.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import week6.burtsbeans.model.Product;
import week6.burtsbeans.model.ProductService;

@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {

    @ManagedProperty(name="searchString", value="")
    private String searchString;
    private final ProductService productService = new ProductService();
    @ManagedProperty(name = "product", value = "")
    private Product product;
    @ManagedProperty(name = "productList", value = "")
    private List<Product> productList;

    public ProductBean() {
        setProductList(productService.getAllProducts());
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

    public String allProducts() {
        productList = productService.getAllProducts();
        return "productList";
    }

    public void setSearchString(String search){
        if(search != null){
            searchString = search;
        }
    }
    
    public String getSearchString(){
        return searchString;
    }
    
    public String searchProducts(){
        this.setProductList(productService.findProducts(searchString));
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
