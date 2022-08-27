package mvcbunch;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/session")

public class CheckLoginSession extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.getOutputStream().println("<h1>surprise mother fucker</h1>");
		response.getOutputStream().println("<img src = \"/Messenger/maxresdefault.jpg\" alt=\"thien dep zai vai dai\">");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if((username.equals("leMinhThien") && password.equals("696969")) || (username.equals("phamkhanhlinh") && password.equals("12345")) || (username.equals("duyklinh") && password.equals("792002")) || (username.equals("phamhongtham") && password.equals("nooneinyoureye"))){
			request.getSession().setAttribute("user", username);
			response.sendRedirect("/Messenger/posts");
		}
		else{
			//in real life you'd probably just render the login screen again
			response.getOutputStream().println("<h1>Wrong username or password.</h1>");
		}

		
	}
}


