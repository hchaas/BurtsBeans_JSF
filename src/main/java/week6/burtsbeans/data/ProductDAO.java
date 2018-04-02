
package week6.burtsbeans.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import week6.burtsbeans.model.Product;

public class ProductDAO {
    public List<Product> getProducts() throws SQLException, Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionUtil.getConnection();
            stmt = conn.prepareStatement("select * from products");
            rs = stmt.executeQuery();

            List<Product> productList = new ArrayList<>();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String productDescription = rs.getString("productDescription");
                int pricePerPound = rs.getInt("pricePerPound");

                Product product = new Product(productID, productName, productDescription, pricePerPound);

                productList.add(product);
            }
            return productList;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
