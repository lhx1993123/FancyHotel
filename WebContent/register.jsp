<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="edu.gatech.cs4400.FancyHotel.Controller.ParameterNames"%>
<t:template>
    <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>New User Registration</h2>
    		</div>
    		<form  action="register" method="POST">
	    		<div class="panel-body">
	    			<input type="text" class="form-control" name="username" placeholder="Username" aria-describedby="basic-addon3">
	   				<br>
	    			<input type="text" class="form-control" name="email" placeholder="E-mail" aria-describedby="basic-addon3">
					<br>
					<input type="password" class="form-control" name="password" placeholder="Password" aria-describedby="basic-addon3">
				    <br>
				    <input type="password" class="form-control" name="passwordAgain" placeholder="Password Again" aria-describedby="basic-addon3">
				    <br>
				    <button class="btn btn-default pull-right" type="submit">Register</button>
	    		</div>
    		</form>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    </jsp:body>
</t:template>