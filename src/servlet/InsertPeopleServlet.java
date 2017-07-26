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
import service.InsertPeopleService;

/**
 * Servlet implementation class InsertPeopleServlet
 */
@WebServlet("/InsertPeopleServlet")
public class InsertPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPeopleServlet() {
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
		p.setPassword(request.getParameter("password"));
		p.setName(request.getParameter("name"));
		p.setWhatfuck(request.getParameter("whatfuck"));
		JDBCOperationDAO dao=new OperationDAOimpl();
		boolean result=dao.insertUser(p);
		if(result){
			response.getWriter().append("错误");
		}else{
			
		}
	}

}
