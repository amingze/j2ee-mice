package mice.service;

import mice.bean.Product;
import mice.dao.ProductDAO;

/**
 * ProductService
 */
public class ProductService {

    public static Product getProduct(int id) {
        Product product = ProductDAO.get(id);
        return product;
    }

}