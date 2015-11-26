<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="edu.gatech.cs4400.FancyHotel.Controller.ParameterNames"%>
<t:template>
    <jsp:body>
    
       	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>View Review </h2>
    		</div>
	   		<div class="panel-body">
	   		<form action="getReview" method="GET">
				<h3>Hotel Location: </h3><span class="label label-default"></span>
					<input list="locations" name="location">
					  <datalist id="locations">
					    <option value="Atlanta">
					    <option value="Charlotte">
					    <option value="Savannah">
					    <option value="Orlando">
					    <option value="Miami">
					  </datalist>
				<br>
				<button class="btn btn-default pull-right" type="submit">Check Reviews</button><br><br>
				<hr>
			</form>
				
				<c:if test="${not empty reviews}">
	    			<table class="table">
				   	<thead>
					    <tr>
					    <th>Rating</th>
					    <th>Comment</th>
					    </tr>
					</thead>
				    <tbody>
			          <c:forEach var="curReview" items="${reviews}">
			          	<tr>
			            <td><c:out value="${curReview.rating}"></c:out></td>
			            <td><c:out value="${curReview.comment}"></c:out></td>
			          	</tr>
			          </c:forEach>
				    </tbody>
					</table>
	   			</c:if>
	   		</div>
	   		
	   		
    	</div>
		
    </jsp:body>
</t:template>