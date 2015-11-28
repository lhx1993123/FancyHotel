<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Confirmation Screen</h2>
    		</div>
    		<div class="panel-body">
    			<p>Confirmation ID: <c:out value="${reservation.reservationID}"></c:out><p>
   				<br>
    			<p>Please save this reservation ID for all further communication.<br>
    		</div>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    </jsp:body>
</t:template>