package mice.servlet;

import java.util.List;

import mice.bean.Category;
import mice.service.CategoryService;

/**
 * CategoryServlet
 */
public class CategoryServlet {
    public static void add(Category category) {
        CategoryService.add(category);
    }

    public static void delete(int catergoryId) {
        CategoryService.delete(catergoryId);

    }

    public static void update(Category category) {
        CategoryService.update(category);
    }

    public static List<Category> list() {
        List<Category> categorys = CategoryService.list();
        return categorys;
    }

}