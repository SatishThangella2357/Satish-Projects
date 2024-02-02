<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Candidate Evaluation Application - Candidate Form</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style>
    .container {
      max-width: 430px;
      padding: 20px;
      border-radius: 1px;
      box-shadow: 0px 0px 10px lightblue;
      margin: 0 auto;
      margin-top: 50px;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Candidate Evaluation</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#">Candidate</a></li>
      <li><a href="#">Feedback</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Reports <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Selected Candidates</a></li>
          <li><a href="#">Not Selected Candidates</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <core:if test="${sessionScope.curr_user != null}">
        <li>
          <h3 style="color: white; display: inline-block;">Welcome</h3>
          <span style="color: red; font-size: 34px;">${curr_user.e_Name}</span>
          <button class="btn btn-danger dropdown-toggle" type="button" data-toggle="dropdown">
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
            <li><a class="btn btn-success" href="/CandidateEvaluation/test/logout">Logout</a></li>
          </ul>
        </li>
      </core:if>
      <core:if test="${sessionScope.curr_user == null}">
        <li>
          <% System.out.println("Hiiii"); %>
          <jsp:forward page="index.jsp" />
        </li>
      </core:if>
    </ul>
  </div>
</nav>
<div class="container">

  <h2>Candidate Registration Form</h2>
  <form action="/CandidateEvaluation/test/candidate/save" method="post" enctype="multipart/form-data">

    <input type="hidden" name="c_ID" value="${candidate.c_ID}" />
    <div class="form-group">
      <label for="c_Name">Candidate Name</label>
      <input type="text" name="c_Name" id="c_Name" class="form-control" value="${candidate.c_Name}" required>
    </div>
    <div class="form-group">
      <label for="c_Email">Candidate Email</label>
      <input type="text" name="c_Email" id="c_Email" class="form-control" value="${candidate.c_Email}"required>
    </div>
    <div class="form-group">
      <label for="c_Phone">Candidate Phone</label>
      <input type="text" name="c_Phone" id="c_Phone" class="form-control" value="${candidate.c_Phone}"required>
    </div>
    <div class="form-group">
      <label for="c_Comments">Candidate Comment</label>
      <textarea name="c_Comments" id="c_Comments" class="form-control">${candidate.c_Comments}</textarea>
    </div>
    <div class="form-group">
      <label for="c_Resume">Candidate Resume</label>
      <input type="file" name="resume" id="c_Resume" class="form-control">
    </div>
    <div class="form-group">
      <label for="c_RegDate">Candidate Enrollment Date</label>
      <input type="date" name="c_RegDate" id="c_RegDate" class="form-control" value="${candidate.c_RegDate}"required>
    </div>
    <core:if test="${error != null}">
      <div class="alert alert-danger">
        ${error}
      </div>
    </core:if>
    <input type="submit" value="Save" class="btn btn-success">
  </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
