package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

	
/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String filePath="";  
    private static String tempPath="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
        super();
        tempPath=getServletContext().getRealPath("/file");
        filePath=getServletContext().getRealPath("/WEB-INF/file");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(!ServletFileUpload.isMultipartContent(request)){
			System.out.print("类型错误");
			return;
		}
		try{
			//配置上传参数
			//使用Apache上传组件处理文件的步骤
			//DiskFileItemFactory factory=new DiskFileItemFactory();
			DiskFileItemFactory factory=new DiskFileItemFactory();;
			//设置缓存
			factory.setSizeThreshold(1024*1024*3);
			//设置文件上传对象
			factory.setRepository(new File(tempPath));
			//创建一个文件上传解析器
			ServletFileUpload upload= new ServletFileUpload(factory);
			//解决上次文件中文乱码问题
			upload.setProgressListener(new ProgressListener() {
				public void update(long arg0, long arg1, int arg2) {
				}
			});
			upload.setHeaderEncoding("utf-8");
			upload.setFileSizeMax(1024*1024*10);
			List<FileItem> list=upload.parseRequest(request);
			String titlt;
			for(FileItem item:list){
				String filename=null;
				if(item.isFormField()){
					filename=item.getFieldName()
					String value=item.getString("utf-8");
				}else{
					String filename=item.getFieldName();
					
				}
			}
		}catch(Exception e){
			
		}
	}

}
