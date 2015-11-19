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
    			<table class="table">
			        <thead>
			          <tr>
			            <th>Room Number</th>
			            <th>Room Category</th>
			            <th># Persons allowed</th>
			            <th>Cost per day</th>
			            <th>Cost of extra bed per day</th>
			            <th>Select Room</th>
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
			          	<td><input type="checkbox" name="selected ${curRoom.roomNumber}" value=""></td>
			          	</tr>
			          </c:forEach>
			        </tbody>
			    </table>
			    <button class="btn btn-default pull-right" type="submit">Check for details</button>
    		</div>
    	</div>
    </jsp:body>
    
</t:template>