<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-image: url('login.jpg'); background-size:cover; background-repeat:norepeat">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Candidate Evaluation</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/CandidateEvaluation/sathome.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Candidates</a></li>
          <li><a href="#">Feedback</a></li>
          <li><a href="#">Show Candidates</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
   
  </div>
</nav>

<div  style="width: 25%; margin-left: 600px; margin-top: 130px; border-radius: 10px; padding: 30PX; box-shadow: 0 0 25px white;">
	<h1 style="align:center; color:pink;" class="glyphicon glyphicon-user ">&nbsp;Login	</h1><br/><br/><br/>
<form action="/CandidateEvaluation/test/login" method="post">

  <div class="input-group">
  
    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    
	
    <input id="DasID" type="text" class="form-control" name="DasID" placeholder=" enter DAS ID" required>
  </div><br>
  <div class="input-group">
  
    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    <input id="Password" type="password" class="form-control" name="Password" placeholder=" enter Password" required>
  </div><br><br>
  
  <button type="submit" class="btn btn-default btn-primary">Submit</button><br><br>
<core:if test="${error!=null}">

            <div class="alert alert-danger">

            ${error}

            </div>

            </core:if>
</form>



		
</div>
</body>
</html>