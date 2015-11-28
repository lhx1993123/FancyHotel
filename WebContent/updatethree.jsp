<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
   <jsp:body>
    	<div class="panel panel-info">
    		<c:if test="${empty errorMessage}">
	    		<div class="panel-heading">
	    			<h2>Rooms are available. Please confirm details below before submitting.</h2>
	    		</div>
	    		<form  action="submitUpdate" method="POST">
		    		<div class="panel-body">
		    			<table class="table">
				            <thead>
				              <tr>
				                <th>Room number</th>
				                <th>Room Category</th>
				                <th>#Persons allowed</th>
				                <th>Cost per day</th>
				                <th>Cost of extra bed per day</th>
				                <th>Extra bed</th>
				              </tr>
				            </thead>
				            <tbody>
				               <c:forEach var="curRoom" items="${newReservation.reserveRelationships}">
					          	<tr>
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
				        <p>Total Cost Updated: <c:out value="${reservation.total_cost}"></c:out> <p>
					    <button class="btn btn-default pull-right" type="submit">Update</button>
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