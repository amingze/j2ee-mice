 package mice.servlet;
 import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

import mice.bean.Goods;
import mice.dao.GoodsDAO;

public class GoodsServlet extends BaseServlet {
	public String li(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		
		return("admin/goods.jsp");
	}
    public String list(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
        Goods bean = new Goods();
		request.setCharacterEncoding("UTF-8");
        request.setAttribute("goodslist", goodsDao.total());
        

        	return("admin/goods.jsp");

        

		
    }
     public String add(HttpServletRequest request,HttpServletResponse response) {

    	        Goods bean=new Goods();
    	        
    	        
    	        bean.setName(request.getParameter("name"));
    	        bean.setPrice(Float.parseFloat(request.getParameter("price")));
    	        
    	        Map<String, String> params=new HashMap<>();
    	        InputStream is=super.parseUpload(request,params);
    	        String name =params.get("name");
    	        Goods goods=new Goods();
    	        goods.setName(name);
    	        goodsDao.add(bean);
    	        File imageFolder=new File(request.getSession().getServletContext().getRealPath("img/goods"));
    	        File file =new File(imageFolder,goods.getName()+".jpg");
//    	        try {
//    	        	if (null!=is&&0!=is.available()) {
//						try(FileOutputStream fos=new FileOutputStream(file)) {
//							
//						
//    	        		byte b[]=new byte[1024*1024];
//						int length=0;
//						while (-1!=(length=is.read(b))) {
//							fos.write(b,0,length);
//						}
//						fos.flush();
////						BufferedImage img=ImageUtil
////						image
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
						
//    	        }catch (Exception e) {
//					e.printStackTrace();
//    	        	// TODO: handle exception
//				}
    	        request.setAttribute("status", "添加成功");
    	        
    		 return "@admin_goods_list";

    }
     public String updata(HttpServletRequest request,HttpServletResponse response) {
		Goods bean = new Goods();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setName(request.getParameter("name"));
		bean.setPrice(Float.parseFloat(request.getParameter("price")));
		GoodsDAO.updata(bean);
		
		request.setAttribute("status", "修改成功");

		return "@admin_goods_list";

     }
     
     public String delete(HttpServletRequest request,HttpServletResponse response) {
    	int id= Integer.parseInt(request.getParameter("id"));
		GoodsDAO.delete(id);
		
		request.setAttribute("status", "删除成功");
		return "@admin_goods_list";

     }
     public String serch(HttpServletRequest request,HttpServletResponse response) {
    	 try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 String goodsName=request.getParameter("goodsName");
    	 List<Goods> beans=GoodsDAO.get(goodsName);
    	 request.setAttribute("goodslist", beans);
    	 System.out.println(goodsName);
		 return "admin/goods.jsp";
	}
     
 }