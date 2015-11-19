<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Update Reservation</h2>
    		</div>
    		<form  action="searchConfirmation" method="GET">
	    		<div class="panel-body">
	    			<p>Confirmation ID:<p>
	    			<input type="text" class="form-control" name="confirmationID" aria-describedby="basic-addon3">
	   				<br>
				    <button class="btn btn-default pull-right" type="submit">Search</button>
	    		</div>
    		</form>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    	
    </jsp:body>
</t:template>