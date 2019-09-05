package com.OnlineShopping.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import com.OnlineShopping.dao.UserDao;
import com.OnlineShopping.pojo.User;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User u=new User();
	UserDao ud=new UserDao();
    
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		String action=request.getParameter("action");

		if(action!=null && action.equals("edit")) {

			String email=request.getParameter("email");
			User u1=ud.getUserByEmail(email);
			session.setAttribute("u", u1);
			response.sendRedirect("updateUser.jsp");
		}else if(action!=null && action.equals("delete")) {
			String email=request.getParameter("email");
			boolean b=ud.deleteUser(email);
			response.sendRedirect("UserServlet");
		}
		else {
			List<User> al=ud.getUserList();
			session.setAttribute("ulist", al);
			response.sendRedirect("userList.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");

		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		u.setName(name);u.setContact(contact);
		u.setEmail(email);u.setPass(pass);
		if(action!=null && action.equals("updateUser")) {

			boolean b=ud.updateUser(u);
			if(b) {
				response.sendRedirect("UserServlet");
			}
		}
		else if(action!=null && action.equals("addUser")) {
			String cpass=request.getParameter("cpass");


			if(pass!=null && pass.equals(cpass)) {

				
				boolean b=ud.addUser(u);
				if(b) {
					response.sendRedirect("success.jsp");
				}else {
					response.sendRedirect("error.jsp");
				}
			}
		}
	}

}
