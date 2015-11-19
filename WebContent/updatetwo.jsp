<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Update Reservation</h2>
    		</div>
    		
    		<form  action="EnterDate" method="Get">
	    		<div class="panel-body">
	    			<span>Current Start Date:    </span><input type="date" name="currentstartdate">
	   				<br>
	    			<span>Current End Date:      </span><input type="date" name="currentenddate">
					<br>
					<span>New Start Date:        </span><input type="date" name="newstartdate">
				    <br>
				    <span>New End Date:          </span><input type="date" name="newenddate">
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