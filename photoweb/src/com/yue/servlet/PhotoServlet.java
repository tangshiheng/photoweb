package com.yue.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yue.bean.Page;
import com.yue.bean.Photo;
import com.yue.service.PhotoService;
import com.yue.service.impl.PhotoServiceImpl;
import com.yue.util.Utils;

/**
 * Servlet implementation class PhotoServlet
 */
public class PhotoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private PhotoService photoservice;

	public PhotoServlet() {
		photoservice = new PhotoServiceImpl();
	}

	// 显示所有的图片信息
	public void showPhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Photo> listPhoto = photoservice.listPhoto();
		System.out.println(listPhoto);
		request.setAttribute("listPhoto", listPhoto);
		request.getRequestDispatcher("photo/show.jsp").forward(request,
				response);
	}

	// 删除图片
	public void deletePhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 首先获取要删除的id
		int id = Utils.parseInt(request.getParameter("id"), 0);
		// 调用操作方法
		int deletePhoto = photoservice.deletePhoto(id);
		System.out.println("删除：" + deletePhoto);
		// 返回当前页面
		response.sendRedirect(request.getHeader("referer"));
	}

	// 查看单个图片的信息
	public void showOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 首先获取id
		int id = Utils.parseInt(request.getParameter("id"), 0);
		System.out.println("获取的id：" + id);
		// 根据id查找图片
		Photo photo = photoservice.onePhoto(id);
		System.out.println("查到的单个图片信息：" + photo);
		request.setAttribute("photo", photo);
		// 转发到更新页面
		request.getRequestDispatcher("photo/update.jsp").forward(request,
				response);
		// response.sendRedirect(request.getContextPath()+"/photoServlet?action=showPhoto");

	}

	// 修改图片
	@SuppressWarnings("unchecked")
	public void updatePhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 创建这个对象
		Photo photo = new Photo();
		photo = (Photo) Utils.copyParameter2Properties(
				request.getParameterMap(), photo);
		int updatePhoto = photoservice.updatePhoto(photo);
		System.out.println("修改：" + updatePhoto);
		response.sendRedirect(request.getContextPath()
				+ "/photoServlet?action=showPhoto");
	}

	// 添加图片
	@SuppressWarnings("unchecked")
	public void addPhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 创建这个对象
		Photo photo = new Photo();
		// 将对象封装到bean中
		photo = (Photo) Utils.copyParameter2Properties(
				request.getParameterMap(), photo);
		// 调用service的方法
		int addPhoto = photoservice.addPhoto(photo);
		System.out.println("添加图片:" + addPhoto);
		response.sendRedirect(request.getContextPath()
				+ "/photoServlet?action=showPhoto");
	}

	// 显示分页后的信息
	public void pagePhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 分析：
		 * 1.首先获取前台传来的页码和记录数
		 * 2.调用sevice的方法来查找当前页的记录
		 * 3.将查询到的记录数返回到显示页面
		 */
		//获取当前页和每页显示的记录数
		int pageNo = Utils.parseInt(request.getParameter("pageNo"), 1);
		int pageSize = Utils.parseInt(request.getParameter("pageSize"),2);
		System.out.println("当前页数："+pageNo);
		//调用service方法来查询每页显示的数据集合 
		Page<Photo> page = photoservice.queryPagePhoto(pageNo, pageSize);
		System.out.println("分页的数据"+page);
		request.setAttribute("page",page);
		
		//转发到显示页面
		request.getRequestDispatcher("photo/show.jsp").forward(request, response);
	}
	//模糊查询
	public void searchPhoto (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//首先获取输入的信息
		String photoName = request.getParameter("photoName");
		
		//调用service查询
		List<Photo> search = photoservice.search(photoName);
		
		//将查询的结果放在search里面
		request.setAttribute("search", search);

		//转发
		request.getRequestDispatcher("photo/search.jsp").forward(request, response);
	}
}
