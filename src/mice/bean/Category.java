package mice.bean;

import java.util.List;

public class Category {
    int id;
    String name;
    int largeCategoryId;

    public int getLargeCategoryId() {
        return this.largeCategoryId;
    }

    public void setLargeCategoryId(int largeCategoryId) {
        this.largeCategoryId = largeCategoryId;
    }

    List<Product> products;

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}