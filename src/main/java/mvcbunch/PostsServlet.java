package mvcbunch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/posts")
public class PostsServlet extends HttpServlet {
 
	private int count = 0;
	Message message;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		count++;
//		response.getOutputStream().println("<h1>New Post</h1>");
//		response.getOutputStream().println("<form action=\"/Messenger/posts\" method=\"POST\">");
//		response.getOutputStream().println("Name: ");
//		response.getOutputStream().println("<input type=\"text\" name=\"name\">");
//		response.getOutputStream().println("<br/>");
//		response.getOutputStream().println("Post: ");
//		response.getOutputStream().println("<input type=\"text\" name=\"post\">");
//		response.getOutputStream().println("<br/>");
//		response.getOutputStream().println("<input type=\"submit\" value=\"Submit\">");
//		response.getOutputStream().println("</form>");
//		response.getOutputStream().println("<hr/>");
//		response.getOutputStream().println("<h1>Prior Posts</h1>");
//		response.getOutputStream().println("<p>(newest on top)</p>");
//		if(DatabaseConnection.instance.getAllPosts() != null)
//		{
//		for(Message post : DatabaseConnection.instance.getAllPosts()){			
//			response.getOutputStream().println("<p>[" + post.getTimestamp() + "] " + post.getName() + ": " + post.getPost() + "</p>");
//			response.getOutputStream().println("<hr/>");
//		}
//		}
		//request.setAttribute("content", message);
		request.getRequestDispatcher("WEB-INF/posts.jsp").forward(request,response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = (String) request.getSession().getAttribute("user");
		String post = request.getParameter("post");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		DatabaseConnection.instance.addPost(name, post, timestamp);
		response.sendRedirect("/Messenger/posts");
	}
}