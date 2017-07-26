package servlet;

import imp.OperationDAOimpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.User;
import DAO.JDBCOperationDAO;

/**
 * Servlet implementation class DeletePeopleServlet
 */
@WebServlet("/DeletePeopleServlet")
public class DeletePeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePeopleServlet() {
        super();
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
		User p=new User();
		p.setId(request.getParameter("id"));
		JDBCOperationDAO dao=new OperationDAOimpl();
		boolean result=dao.deleteUser(p);
		if(result){
			response.getWriter().append("错误");
		}else{
			
		}
	}

}
