package servlet;

import service.EmpService;
import service.impl.EmpServiceImpl;
import util.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//做分页处理，获得页号，查询出对应的数据，跳转页面显示分页数据
public class FyServlet extends HttpServlet {

    private EmpService service = new EmpServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页号
        int pageno=1;
        String strPageNo = request.getParameter("pageNo");
        //如果没有提供页号参数，那么就使用默认值1
        if(strPageNo!=null&&!strPageNo.equals("")){
            pageno = Integer.parseInt(strPageNo);
        }

        //调用业务进行分页查询
        Page page = service.getByPage(pageno);


        //跳转页面
        request.setAttribute("page",page);

        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }
}
