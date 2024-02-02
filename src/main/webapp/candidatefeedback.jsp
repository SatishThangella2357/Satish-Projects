<%@page import="com.Bootcamp.model.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeLeaf.org">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <link href="<core:url value="/test/resources/css/main.css"/>" rel="stylesheet">
</head>
<body style="width:100">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Candidate Evaluation</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li><a href="/CandidateEvaluation/candidatelist.jsp">Candidate</a></li>
      <li><a href="/CandidateEvaluation/candidatefeedbackdetails.jsp">Feedback</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Reports <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/CandidateEvaluation/test/candidate/selected">Selected Candidates</a></li>
          <li><a href="/CandidateEvaluation/test/candidate/notselected">Not Selected Candidates</a></li>
        </ul>
      </li>
      
    </ul>
    <ul class="nav  navbar-right">
    
     	<core:if test="${sessionScope.curr_user!=null}">
        <h3 ><span style="color:white">Welcome</span><span style="color:red; font-size: 34px;"> ${curr_user.e_Name }</span>
		  <button class="btn btn-danger dropdown-toggle" type="button" data-toggle="dropdown">
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a class="btn btn-success" href="/CandidateEvaluation/test/logout">Logout</a></li></ul>
		</ul>
		</core:if>
		<core:if test="${sessionScope.curr_user==null}">
			<%System.out.println("Hiiii");%>
			<jsp:forward page="index.jsp"/>
		</core:if>
      </div>


</nav>


<div class="container">
  <form class="form-inline" action="/CandidateEvaluation/test/candidate/search">
 
    <input type="search" class="form-control " name="c_Name" placeholder="Enter search element"style=" width:600px; padding:20px" required>
     <button type="submit" class="btn btn-success" style="  padding:10px">Search</button> <br>
    
    </form>
  
  </div><br>
			
	
	
	<core:if test="${!Feedback}" >
<a href="/CandidateEvaluation/test/feedback/add/${candidate.c_ID}">add feedback</a>
</core:if>
	<div class="row my-2" style="margin:AUTO">
		
			<h2>Candidate Feedback</h2>
			<table class="table table-bordered table-striped m-2">
				<tr>
					<th colspan="2">Candidate Id</th>
					<td>${candidate.c_ID }</td>
				</tr>
				<tr>
					<th colspan="2">Candidate Name</th>
					<td>${candidate.c_Name }</td>
				</tr>
				<tr>
					<th colspan="2">Candidate Resume</th>
					<td><a   href="<core:url value="/test/resources/resume/${candidate.c_Resume}"/>">${candidate.c_Resume}</a>
<%-- 					<td ><a href="/CandidateEvaluation/src/main/webapp/resources/resume/${candidate.c_Resume }">${candidate.c_Resume }</a></td> --%>
				</tr>
<%-- 								${candidate} <br> --%>
<%-- ${candidate.c_Name}<br> --%>
<%-- ${candidate.candidateFeedback}<br> --%>
				<tr>

					<th> Evaluator ID</th>
					<th>Evaluator Name</th>
					<th>Screening Level</th>
					<th>Status</th>
					<th>Comment</th>
				</tr>					
				<core:forEach var="feedback" items="${candidate.candidateFeedback}">
						<tr>
						<td>${feedback.e_ID }</td>
						
							<td>${feedback.fe_ID.e_Name}</td>
							<td>${feedback.f_ScreeningLevel }</td>
							
							<td>${feedback.feedbackStatus }</td>
							<td>${feedback.f_Comments }</td>
						</tr>
					</core:forEach>
						
					
				
				
			</table>
		
		
	</div>
</div>
</body>
</html>