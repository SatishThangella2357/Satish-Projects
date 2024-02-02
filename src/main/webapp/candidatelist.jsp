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


<div class="container">
  <form class="form-inline" action="/CandidateEvaluation/test/candidate/search">
 
    <input type="search" class="form-control " name="c_Name" placeholder="Enter search element"style=" width:600px; padding:20px" required>
     <button type="submit" class="btn btn-success" style="  padding:10px">Search</button> <br>
    
    </form>
  
  </div><br>
 
 <a  href="/CandidateEvaluation/test/candidate/add" class="btn btn-primary"  style="  margin-left:9%; padding:10px" >Add New Candidate</a>
<br><br>



  </table>
  <core:if test="${candidatelist.size()>0}">
  <table class="table table-striped table-bordered ">
				<thead class="bg-secondary">
	<tr>
	  <th>ID</th>
      <th>Name</th>
      <th>Phone</th>
      <th>Email</th>
      <th>Resume</th>
	  <th>Comment</th>
      <th>Enrollment Date</th>
	  <th>Actions</th>
					</tr>
				</thead>
				
				<tbody><tr>

					<core:forEach var="candidate" items="${candidatelist}">

						<td>${candidate.c_ID }</td>
  							 <td>${candidate.c_Name }</td>
 							  <td>${candidate.c_Phone }</td>
 							  <td>${candidate.c_Email }</td>
 							  <td>${candidate.c_Resume }</td>
  							 <td>${candidate.c_Comments }</td>
  								 <td>${candidate.c_RegDate }</td>
						<td>
							<a href="/CandidateEvaluation/test/candidate/delete/${candidate.c_ID}" class="btn btn-outline-danger m-2"><i class="glyphicon glyphicon-trash glyphicon-trash-success "></i></a>
								<a href="/CandidateEvaluation/test/candidate/edit/${candidate.c_ID}" class="btn btn-outline-warning m-2"><i class="glyphicon glyphicon-edit"></i></a>
								<a href="/CandidateEvaluation/test/candidate/view/${candidate.c_ID}" class="glyphicon glyphicon-eye-open"><i class="bi bi-eye-fill"></i></a>

						</td>
					</tr></core:forEach>
				</tbody>
				
			</table>
				</core:if>
	<core:if test="${candidatelist.size()==0}">
		<div class="alert alert-danger m-2"> No Candidate Found.....</div>
	</core:if>
			

</body>
</html>