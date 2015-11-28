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
	    			<table style="width:100%">
					  <tr>
					    <td>
							<h3>Current Start Date: </h3>
							<div><c:out value="${reservation.start_date}"></c:out></div>
						</td>
					    <td>
					    	<h3>Current End Date: </h3>
							<div><c:out value="${reservation.end_date}"></c:out></div>
					    </td> 
					  </tr>
					  <tr>
					    <td>
							<h3>New Start Date: </h3>
							<input type="date" name="newstartdate">
						</td>
					    <td>
					    	<h3>New End Date: </h3>
							<input type="date" name="newenddate">
					    </td> 
					  </tr>
					</table>
					<button class="btn btn-default pull-right" type="submit">Search Availability</button>
	    		</div>
    		</form>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    	
    </jsp:body>
</t:template>