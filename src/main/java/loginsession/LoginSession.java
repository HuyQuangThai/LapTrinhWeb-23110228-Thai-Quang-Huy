package loginsession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/loginsession"})
public class LoginSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		if (user.equals("huy") && pass.equals("123")) {
			out.print("Hello, " + user);
			HttpSession session = req.getSession();
			session.setAttribute("name", user);
		}
		else {
			out.print("Username or password is incorrect");
			req.getRequestDispatcher("loginsession.html").include(req, resp);
		}
	}
}
