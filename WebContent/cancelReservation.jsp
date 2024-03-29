<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
   <jsp:body>
    	<div class="panel panel-info">
    		<c:if test="${empty errorMessage}">
	    		<div class="panel-heading">
	    			<h2>Your reservation summary</h2>
	    			<h2>Please confirm before you make cancellation</h2>
	    		</div>
	    		<form  action="cancelServlet" method="POST">
		    		<div class="panel-body">
		    			<table class="table">
				            <thead>
				              <tr>
				              	<th>Start Date</th>
				              	<th>End Date</th>
				                <th>Room number</th>
				                <th>Room Category</th>
				                <th>#Persons allowed</th>
				                <th>Cost per day</th>
				                <th>Cost of extra bed per day</th>
				                <th>Extra bed</th>
				              </tr>
				            </thead>
				            <tbody>
				               <c:forEach var="curRoom" items="${reservation.reserveRelationships}">
					          	<tr>
					          	<td><c:out value="${reservation.start_date}"></c:out></td>
					          	<td><c:out value="${reservation.end_date}"></c:out></td>
					            <td><c:out value="${curRoom.room.roomNumber}"></c:out></td>
					            <td><c:out value="${curRoom.room.roomCategory}"></c:out></td>
					            <td><c:out value="${curRoom.room.numberOfPeople}"></c:out></td>
					            <td><c:out value="${curRoom.room.cost}"></c:out></td>
					          	<td><c:out value="${curRoom.room.costPerExtraBed}"></c:out></td>
					          	<td><c:if test="${curRoom.hasExtraBed}">
					          		Yes
					          		</c:if>
					          		<c:if test="${not curRoom.hasExtraBed}">
					          		No
					          		</c:if>
					          	</td>
					          	</tr>
				          </c:forEach>
				            </tbody>
				          </table>
				        <p>Total Cost: <c:out value="${reservation.total_cost}"></c:out> <p>
				        <p>Amount to be refunded: <c:out value="${refund}"></c:out> <p>
					    <button class="btn btn-default pull-right" type="submit">Cancel</button>
		    		</div>
	    		</form>
    		</c:if>
    		<c:if test="${not empty errorMessage}">
		    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
		    	<a href="<c:url value="/main"/>" class="btn btn-default pull-right">No</a>
		    	<a href="<c:url value="/cancel"/>" class="btn btn-default pull-right">Yes</a>
		    </c:if>
    	</div>
    </jsp:body>
</t:template>