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
	<section >
		<div class="container">
			<div class="row">
				<div class="col-md-8 offset-md-2">
					<div class="my-card mt-5" >
					
						
						<div class="container text-center">
							<img width="80px" src="/user.png" alt="" />
						</div>
						<h1 class="text-center display-block">
							Login here..
						</h1>
						<form action="/dologin"  method="post">
						
							
							<div class="mb-3 form-group">
							    <label for="email" class="form-label">Your Email</label>
							    <input name="username" type="email" class="form-control" id="email" placeholder="Enter here" aria-describedby="emailHelp">
							 </div>
							 
							 <div class="mb-3 form-group">
							    <label for="password" class="form-label">Your Password</label>
							    <input name="password" type="password" class="form-control" placeholder="Enter here" id="password">
							 </div>
						
							 <div class="form-group form-check">
							 	<input name="rememberme" type="checkbox" class="form-check-input" id="rememberme" />
							 	<label for="rememberme">Remember me</label>
							 </div>
							 
							 
							 
						
							 
							 <div class="text-center">
							 	<button type="submit" class="btn bg-primary text-white">Submit</button>
							 </div>
							 
						</form>
						<div class="container my-1">
                            <a href="signUp" class="text-info" >Register here</a>
                        </div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>