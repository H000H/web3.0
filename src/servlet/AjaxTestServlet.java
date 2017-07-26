package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pro.User;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet("/AjaxTestServlet")
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTestServlet() {
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
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-control", "no-cache");
		User user=new User();
		user.setId("wexiin");
		user.setName("ss");
		ArrayList<User> list=new ArrayList<>();
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		System.out.print(getServletContext().getRealPath("/image"));
		JSONArray json=JSONArray.fromObject(list);
//		response.getWriter().append(json.toString());
		PrintWriter out =response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}

}
