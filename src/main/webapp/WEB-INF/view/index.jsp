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
	<% String flag=(String)session.getAttribute("flag"); %>
	<%session.removeAttribute("flag"); %>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-8 offset-md-2">
					<div class="my-card mt-5">
					<%if(flag=="success"){ %>
					<div class="alert alert-success" role="alert">
  						Mail send successfully !!
					</div>
					<%}%>
					
					<%if(flag=="danger"){ %>
					<div class="alert alert-danger" role="alert">
  						Something went wrong !!
					</div>
					<%}%>
					
					
			
						<div class="container text-center">
							<img width="80px" src="/email1.jpg" alt="" />
						</div>
						<h1 class="text-center display-block">
							Compose mail..
						</h1>
						
						<form action="/user/sendMail" method="post" enctype="multipart/form-data">
							
							<div class="mb-3 form-group">
							    <label class="form-label">Your Mail Password</label>
							    <input name="password" type="password" class="form-control"  placeholder="********" />
							 </div>
							 
							<div class="mb-3 form-group">
							    <label class="form-label">To</label>
							    <input name="to" type="email" class="form-control"  placeholder="abc@gmail.com" />
							 </div>
							
							<div class="mb-3 form-group">
							    <label class="form-label">Subject</label>
							    <input name="subject" type="text" class="form-control"  placeholder="Enter here" aria-describedby="emailHelp" />
							 </div>
							 
						
							
							 <div class="mb-3 form-group">
							    <label for="msg" class="form-label">Message</label>
							    <textarea name="msg" class="form-control" placeholder="Write message here..." ></textarea>
							 </div>
							 
							 <div class="mb-3 form-group">
							    <label class="form-label">Attechment</label>
							     <input name="file" type="file" class="form-control"  />
							 </div>
							
							
							 <div class="text-center">
							 	<button type="submit" class="btn bg-primary text-white">Send</button>
							 	<button type="reset" class="btn btn-danger text-white">Reset</button>
							 </div>
							  
						</form>
							<div class="container my-1">
                                <a href="/logout" class="text-info" >Logout</a>
                             </div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>