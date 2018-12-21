package mice.service;

import java.util.List;

import mice.bean.Category;
import mice.dao.CategoryDAO;

/**
 * ImageService
 */
public class ImageService {

    public static List<Category> list() {
        return CategoryDAO.list();
    }
}