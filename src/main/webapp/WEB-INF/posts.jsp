<%@ page import="mvcbunch.DatabaseConnection" %>
<%@ page import="mvcbunch.Message" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>New Post</title>
      <style>
Body {  
font-family: Calibri, Helvetica, sans-serif;  
background-color: pink;  
}  
button {   
       background-color: #4CAF50;   
       width: 100%;  
        color: orange;   
        padding: 15px;      
        border: none;   
        cursor: pointer;   
         }   
 textarea{   
  width: 100%;
  height: 150px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  resize: yes;
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        background-color: lightblue;  
    }   
      </style>
	 </head>
	 <body>
	  <form action="/Messenger/posts" method="POST">
	    <p>content:</p>	<textarea name="post"></textarea>
	    <br></br>
	    <input type="submit" value="Submit">
	    </form>
	  <form action="/Messenger/files" method="POST" enctype="multipart/form-data">
			<p>What file do you want to upload?</p>
			<input type="file" name="fileToUpload">
			<br></br>
			<input type="submit" value="Submit">
      </form>
	    <hr>
	    <h1>Prior Posts</h1>
	    <p>(newest on top)</p>
		   <% for(mvcbunch.Message post : DatabaseConnection.instance.getAllPosts()){ %>
			<p><%= ""+ post.getTimestamp() + "[ "+ post.getName() + " ]" + ": " + post.getPost()%></p>
		<hr/>
		<%}%>
	 </body>
</html>
	    