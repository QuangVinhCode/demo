<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<base href="/Web/">
    <title>CRUD User</title>
  </head>
  <body>
    <main class="container">
    	<div class="row">
    		<div class="col">
    			<c:if test="${not empty message }">
    				<div class="alert alert-success">${message }</div>
    			</c:if>
    			<c:if test="${not empty error }">
    				<div class="alert alert-danger">${error }</div>
    			</c:if>  			
    		</div>
    	</div>
    	<div class="row">
    		<div class="col">
    		<form action="UserServlet" method="post">
    			<div class="form-group">
    				<label for="userId">User ID:</label>
    				<input type="text" name="userld" id="userld" class="form-control" value="${user.userld }"/> 				
    			</div>
    			<div class="form-group">
    				<label for="password">Password:</label>
    				<input type="password" name="password" id="password" class="form-control" value="${user.password }"/> 				
    			</div>
    			<div class="form-group">
    				<label for="password">Fullname:</label>
    				<input type="text" name="fullname" id="fullname" class="form-control" value="${user.fullname }"/> 				
    			</div>
    			<div class="form-check form-check -inline">
    				<label>Role:</label>
    				<label><input type="radio" name="admin" id="user" class="form-control" />User</label>		
    			</div>
    			<div class="form-group">
    				<button class="btn btn-primary" formaction="UserServlet/create">Create</button>
    				<button class="btn btn-warning" formaction="UserServlet/update">Update</button>
    				<button class="btn btn-danger" formaction="UserServlet/delete">Delete</button>
    				<button class="btn btn-info" formaction="UserServlet/reset">Reset</button>
    			</div>
    		</form>
    		</div>
    	</div>
    	<div class="row">
    		<div class="col">
    			<table class="table table-stripe">
    				<tr>
    					<td>User ID</td>
    					<td>Password</td>
    					<td>Fullname</td>
    					<td>&nbsp;</td>   					
    				</tr>
    				<c:forEach var="item" items="${users }">
    					<tr>
    					<td>${item.userld }</td>
    					<td>${item.password }</td>
    					<td>${item.fullname }</td>
    					<td>
    						<a href="UserServlet/edit?userld=${item.userld }">Edit</a>
    						<a href="UserServlet/delete?userld=${item.userld }">Delete</a>
    					</td>   					
    				</tr>	
    				</c:forEach>    					
    			</table>
    		</div>
    	</div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

    
  </body>
</html>