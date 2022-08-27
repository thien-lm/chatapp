package mvcbunch;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/files")
@MultipartConfig
(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//get the file chosen by the user
				Part filePart = request.getPart("fileToUpload");
				String fileName = filePart.getSubmittedFileName();
				//get the InputStream to store the file somewhere
			    for (Part part : request.getParts()) {
			        part.write("C:/Users/Administrator/Desktop/for web dev/Messenger/src/main/webapp/WebContent/uploaded-files/" + fileName);
			      }
			    //for example, you can copy the uploaded file to the server
			    //note that you probably don't want to do this in real life!
			    //upload it to a file host like S3 or GCS instead
			   // filePart.write("C:\\Users\\Administrator\\Desktop\\for web dev\\Messenger\\src\\main\\webapp\\WebContent" + fileName);
				
				//get the URL of the uploaded file
				String fileUrl = "http://localhost:8080/MessengerMessenger/WebContent/uploaded-files/" + filePart.getSubmittedFileName();
				
				//You can get other form data too
				String name = (String)request.getParameter("user");
				
				//create output HTML that uses the 
				response.getOutputStream().println("<p>Thanks " + name + "! Here's a link to your uploaded file:</p>");
				response.getOutputStream().println("<p><a href=\"" + fileUrl + "\">" + fileUrl + "</a></p>");
				response.getOutputStream().println("<img src=\"" + fileUrl + "\" />");
				response.getOutputStream().println("<p>Upload another file <a href=\"http://localhost:8080/Messenger/posts\">here</a>.</p>");	
	}
}
