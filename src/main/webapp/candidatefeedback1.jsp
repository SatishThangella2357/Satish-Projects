<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<core:if test="${!Feedback}" >
<a href="/CandidateEvaluation/test/feedback/add/${candidate.c_ID}">add feedback</a>
</core:if>
${candidate} <br>
${candidate.c_Name}<br>
${candidate.candidateFeedback}<br>
</body>
</html>