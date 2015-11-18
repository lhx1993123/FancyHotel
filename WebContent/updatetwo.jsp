<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<style type='text/css'>
.left { width: 25%; float:left; test-align:left; display:inline; }
.right { width: 60%; float:right; text-align:left; display:inline; }
</style>
<t:template>
    <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Update Reservation</h2>
    		</div>
    		
    		<form  action="Date Enter" method="POST">
	    		<div class="panel-body">
	    			<div class='left'><p>Current Start Date</p></div><div class='right'><input type="text" class="form-control" name="currentSdate" placeholder="Current Start Date" aria-describedby="basic-addon3"></div>
	   				<br>
	    			<div class='left'><p>Current End Date</p></div><div class='right'><input type="text" class="form-control" name="currentEdate" placeholder="Current End Date" aria-describedby="basic-addon3"></div>
					<br>
					<div class='left'><p>New Start Date</p></div><div class='right'><input type="password" class="form-control" name="newSdate" placeholder="New Start Date" aria-describedby="basic-addon3"></div>
				    <br>
				    <div class='left'><p>New End Date</p></div><div class='right'><input type="password" class="form-control" name="newEdate" placeholder="New End Date" aria-describedby="basic-addon3"></div>
				    <br>
				    <button class="btn btn-default pull-right" type="submit">Search Availability</button>
	    		</div>
    		</form>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    	
    </jsp:body>
</t:template>