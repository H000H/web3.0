package servlet;

import imp.OperationDAOimpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pro.User;
import DAO.JDBCOperationDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User p=new User();
		p.setId(request.getParameter("id"));
		p.setPassword(request.getParameter("password"));
		System.out.print(p.getId()+p.getPassword());
		if(p.getId()==null||p.getPassword()==null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		JDBCOperationDAO dao=new OperationDAOimpl();
		User result=dao.login(p);
		if(result.getName()==null){
			response.getWriter().append("wrong is happening");
		}else if(result.getPassword().equals(p.getPassword())){
			HttpSession session=request.getSession();
			session.setAttribute("adminName", p.getName());
			session.setAttribute("adminId", p.getId());
			session.setMaxInactiveInterval(60*5);
			request.getRequestDispatcher("/user/userinfo.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
