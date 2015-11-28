<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
        <div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Search Rooms</h2>
    		</div>
    		<div class="panel-body">
    		  <form action="selectRooms" method="POST">
    			<table class="table">
			        <thead>
			          <tr>
			            <th>Room Number</th>
			            <th>Room Category</th>
			            <th># Persons allowed</th>
			            <th>Cost per day</th>
			            <th>Cost of extra bed per day</th>
			            <th>Select Room</th>
			            <th>Extra Bed</th>
			          </tr>
			        </thead>
			        <tbody>
			        
			          <c:forEach var="curRoom" items="${rooms}">
			          	<tr>
			            <td><c:out value="${curRoom.roomNumber}"></c:out></td>
			            <td><c:out value="${curRoom.roomCategory}"></c:out></td>
			            <td><c:out value="${curRoom.numberOfPeople}"></c:out></td>
			            <td><c:out value="${curRoom.cost}"></c:out></td>
			          	<td><c:out value="${curRoom.costPerExtraBed}"></c:out></td>
			          	<td><input type="checkbox" name="selectedRooms" value="${curRoom.roomNumber}"></td>
			          	<td><input type="checkbox" name="selectedExtraBeds" value="${curRoom.roomNumber}"></td>
			          	</tr>
			          </c:forEach>
			        </tbody>
			    </table>
			    
			    <table style="width:100%">
				  <tr>
				    <td>
						<h3>Start Date: </h3>
						<div><c:out value="${startdate}"></c:out></div>
					</td>
				    <td>
				    	<h3>End Date: </h3>
						<div><c:out value="${enddate}"></c:out></div>
				    </td> 
				  </tr>
				  <tr>
				    <td>
				    	<h3> </h3>
				    	<span>Total Cost:</span>
				    	<span>
				    		<c:if test="${not empty cost}">
					    		<c:out value="${cost}"></c:out>
					    	</c:if>
					    	<c:if test="${empty cost}">
					    		0.0
					    	</c:if>
				    	</span>
				    </td>
				    <td>
				    	<input list="cards" name="card">
				    	
						  <datalist id="cards">
						  	<c:forEach var="card" items="${user.cards}">
						    <option value="${card.cardNo}">
						    </c:forEach>
						  </datalist>
						 <a href="<c:url value="/addcard"/>">Add Card</a>
				    </td>
				  </tr>
				</table>
			    
				<br>
				<button class="btn btn-default pull-right" type="submit" name="submit">Submit</button>
				<button class="btn btn-default pull-right" type="submit" name="checkprice">Check Price</button>
			  </form>
    		</div>
    	</div>
    </jsp:body>
    
</t:template>