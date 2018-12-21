package mice.service;

import java.util.List;
import mice.bean.*;
import mice.dao.CategoryDAO;

/**
 * CategoryService
 */
public class CategoryService {
    public static List<Category> list() {
        return CategoryDAO.list();
    }

    public static void add(Category category) {
    }

    public static void update(Category category) {
    }

    public static void delete(int catergoryId) {
    }
}