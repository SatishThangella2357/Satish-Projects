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
<body>
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



<div class="container my-2 border" style="padding: 20px; align:center;width:430px; ">
    <h2>Candidate Feedback Form</h2>
    <form action="/CandidateEvaluation/test/feedback/save" method="post">
        <input type="hidden" name="f_ID" value="0" />
        <div class="mb-3">
            <label for="feedbackCandidate" class="form-label">Candidate Name</label>
            <input type="hidden" name="c_ID" value="${candidate.c_ID}">
            <input type="text" name="c_Name" value="${candidate.c_Name}" class="form-control border-primary rounded-pill" />
        </div>
        <div class="mb-3">
            <label for="feedbackEvalutorId" class="form-label">Evaluator Name</label>
            <input type="hidden" name="e_ID" value="${curr_user.e_ID}">
            <input type="text" name="e_Name" value="${curr_user.e_Name}" class="form-control border-primary rounded-pill" />
        </div><br><br>
        <div class="mb-3">
            <label for="f_ScreeningLevel" class="form-label">Screening Level</label>
            <select name="f_ScreeningLevel" id="f_ScreeningLevel" class="form-select border-primary rounded-pill">
                <option value="">Select</option>
                <core:forEach var="value" items="${screeninglevels}">
                    <option value="${value}">${value}</option>
                </core:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="Feedback" class="form-label">Status</label>
            <select name="feedbackStatus" id="feedbackStatus" class="form-select border-primary rounded-pill">
                <option value="">Select</option>
                <option value="selected">Selected</option>
                <option value="notselected">Not Selected</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="f_Comments" class="form-label">Feedback Comment</label>
            <textarea name="f_Comments" id="f_Comments" class="form-control border-primary rounded" style="padding: 10px; width: 100%;">${feedback.f_Comments}</textarea>
        </div><br/>
        <input type="submit" value="Save" class="btn btn-success btn-lg rounded-pill px-5" />
    </form>
</div>



</body>

</html>