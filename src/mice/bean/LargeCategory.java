package mice.bean;

import java.util.ArrayList;
import java.util.List;

public class LargeCategory {
    private int id;
    private String name;
    private List<List<Product>> largeCategory = new ArrayList<>();

    public List<List<Product>> getLargeCategory() {
        return this.largeCategory;
    }

    public void setLargeCategory(List<List<Product>> largeCategory) {
        this.largeCategory = largeCategory;
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