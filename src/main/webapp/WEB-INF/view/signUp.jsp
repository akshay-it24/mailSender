<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/style.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-8 offset-md-2">
					<div class="my-card mt-5">
			
						<div class="container text-center">
							<img width="80px" src="/registration.png" alt="" />
						</div>
						<h1 class="text-center display-block">
							Register here..
						</h1>
						
						<f:form action="/doSignUp" method="post" modelAttribute="user">
							
							<div class="mb-3 form-group">
							    <label for="name" class="form-label">Your Name</label>
							    <f:input path="name" class="form-control"  placeholder="Enter here" />
							 </div>
							
							<div class="mb-3 form-group">
							    <label for="email" class="form-label">Your Email</label>
							    <f:input path="email" type="email" class="form-control"  placeholder="Enter here" aria-describedby="emailHelp" />
							 </div>
							 
							 <div class="mb-3 form-group">
							    <label for="password" class="form-label">Your Password</label>
							    <f:input path="password"  type="password" class="form-control" placeholder="Enter here" id="password" />
							 </div>
							
							 
							
							
							 <div class="text-center">
							 	<button type="submit" class="btn bg-primary text-white">Submit</button>
							 	<button type="reset" class="btn btn-danger text-white">Reset</button>
							 </div>
							  
						</f:form>
							<div class="container my-1">
                                <a href="/login" class="text-info" >Login here</a>
                             </div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>