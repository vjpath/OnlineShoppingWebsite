package com.OnlineShopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.List;

import com.OnlineShopping.dao.ProductDao;
import com.OnlineShopping.pojo.Product;
import com.OnlineShopping.pojo.User;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product p=new Product();
	ProductDao pd=new ProductDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		if(action!=null && action.equals("delete")) {
			int Pid=Integer.parseInt(request.getParameter("pid"));
			boolean b=pd.deleteProduct(Pid);
			if(b)
			{
			response.sendRedirect("ProductServlet");
			}
		}else if (action!=null && action.equals("edit")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			Product p=pd.getProductById(pid);
			session.setAttribute("p",p);
			response.sendRedirect("UpdateProduct.jsp");
			
		}
		else {
			
				
	
		List<Product> lp=pd.getProductList();
		session.setAttribute("ProductList", lp);
		response.sendRedirect("ProductList.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String Pname=request.getParameter("pname");
		String Category=request.getParameter("Category");
		int qty =Integer.parseInt(request.getParameter("qty"));
		float price=Float.parseFloat(request.getParameter("price"));
		String Des=request.getParameter("Des");
		
		p.setPname(Pname);
		p.setCategory(Category);
		p.setQuantity(qty);
		p.setPrice(price);
		p.setDescription(Des);
		boolean b=pd.addProduct(p);
		if(b) {
			out.println("Success");
			
		}else {
			out.println("Error");
		}
	}

}
