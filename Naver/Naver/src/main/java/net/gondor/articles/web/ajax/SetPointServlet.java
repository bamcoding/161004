package net.gondor.articles.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gondor.constants.Session;
import net.gondor.support.Param;
import net.gondor.users.biz.UserBiz;
import net.gondor.users.biz.UserBizImpl;
import net.gondor.users.vo.UserVO;

public class SetPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz biz;
    private Param param = new Param();
    public SetPointServlet() {
        super();
        biz = new UserBizImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute(Session.SESSION_INFO);
		String point = request.getParameter("point");
		System.out.println(point);
		int point2 = Integer.parseInt(point);
		boolean isTrue = biz.addPoint(user.getId(), point2);
		
		PrintWriter out = response.getWriter();
		out.print(isTrue+"");
		out.flush();
		out.close();
	}
}
