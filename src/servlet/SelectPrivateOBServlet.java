package servlet;

import imp.OperationDAOimpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pro.OB;
import pro.User;
import DAO.JDBCOperationDAO;

/**
 * Servlet implementation class SelectPrivateOBServlet
 */
@WebServlet("/SelectPrivateOBServlet")
public class SelectPrivateOBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPrivateOBServlet() {
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
		HttpSession session=request.getSession();
		String userId=(String)session.getAttribute("adminId");
		System.out.println("admin="+userId);
		JDBCOperationDAO dao1=new OperationDAOimpl();
		int pages=dao1.selectOBPage();
		JDBCOperationDAO dao=new OperationDAOimpl();
		int i=0;
		List<OB> list=null;
		if(request.getParameter("obpage")!=null&&(i=Integer.parseInt(request.getParameter("obpage")))!=0){	
			list=dao.selectAllOb(i,userId);}
		else{
			list=dao.selectAllOb(1,userId);
		}
		if(list==null||list.isEmpty()){
		}else{
			request.setAttribute("allpages", pages);
			request.setAttribute("OBlist", list);
		}
		request.getRequestDispatcher("/user/selectPeople.jsp").forward(request, response);
	}

}
