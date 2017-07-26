package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="CostomerFilter",urlPatterns="/admin/*")
public class CostomerFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
//		doFilter(arg0, arg1);
		System.out.print("sssssss");
		HttpServletRequest rq=(HttpServletRequest)arg0;
		HttpServletResponse rs=(HttpServletResponse)arg1;
		HttpSession session=rq.getSession();
		rs.setContentType("text/html; charset=UTF-8");;
		rq.setCharacterEncoding("UTF-8");
		if((String)session.getAttribute("adminName")==null){
			rq.getRequestDispatcher("../index.jsp").forward(rq,rs);
		}
		if("weixin".equals((String)session.getAttribute("adminName"))){
			rq.getRequestDispatcher("../SelectPrivateOBServlet").forward( rq,rs);
			System.out.print("sssssss");
		}
		
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
}
