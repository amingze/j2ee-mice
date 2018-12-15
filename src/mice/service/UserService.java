package mice.service;

import mice.bean.User;
import mice.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;

/**
 * UserService
 */
public class UserService {
    protected static UserDAO userDAO = new UserDAO();

    public static boolean register(User userBean) {
        User bean = new User();
        bean.setName(userBean.getName());
        bean.setPasswd(userBean.getPasswd());
        try {
            if (userDAO.isNoExist(bean.getName())) {
                userDAO.add(bean);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isLogin(User userBean) {
        if (null == login(userBean.getName(), userBean.getPasswd())) {
            return true;
        }
        return false;

    }

    public static User login(String name, String passwd) {
        User bean = UserDAO.check(name, passwd);
        if (null == bean) {
            return null;
        }
        return bean;
    }
}