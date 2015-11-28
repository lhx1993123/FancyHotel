<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="edu.gatech.cs4400.FancyHotel.Controller.ParameterNames"%>
<t:template>
    <jsp:body>
    
       	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Popular Room-Category </h2>
    		</div>
    		
	   		<div class="panel-body">
   			    <table class="table">
			   	<thead>
				    <tr>
				    <th>Month</th>
				    <th>top room-category</th>
				    <th>Location</th>
				    <th>Total number of reservations for room category</th>
				    </tr>
				</thead>
			    <tbody>
		          <c:forEach var="curCat" items="${Cats}">
		          	<tr>
		            <td><c:out value="${curCat.month}"></c:out></td>
		            <td><c:out value="${curCat.category}"></c:out></td>
		            <td><c:out value="${curCat.location}"></c:out></td>
		            <td><c:out value="${curCat.numOfRes}"></c:out></td>
		            
		          	</tr>
		          </c:forEach>
			    </tbody>
				</table>
	   		</div>
    	</div>	
    </jsp:body>
</t:template>