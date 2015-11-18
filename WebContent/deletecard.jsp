<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Delete Card</h2>
    		</div>
    		<form  action="card info" method="POST">
	    		<div class="panel-body">
	    			<p>Card Number:</p>
	    			<select name="category" id="single1">
					     <option></option>
					     <option></option>
					     <option></option>
					     <option></option>
					</select>
					<button class="btn btn-default pull-right" type="delete">Delete</button>
	    		</div>
    		</form>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    	
    </jsp:body>
</t:template>