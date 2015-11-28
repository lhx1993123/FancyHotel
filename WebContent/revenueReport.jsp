<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="edu.gatech.cs4400.FancyHotel.Controller.ParameterNames"%>
<t:template>
    <jsp:body>
    
       	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Revenue Report </h2>
    		</div>
    		
	   		<div class="panel-body">
   			    <table class="table">
			   	<thead>
				    <tr>
				    <th>Month</th>
				    <th>Location</th>
				    <th>Total revenue</th>
				    </tr>
				</thead>
			    <tbody>
		          <c:forEach var="curManagerReport" items="${ManagerReports}">
		          	<tr>
		            <td><c:out value="${curManagerReport.month}"></c:out></td>
		            <td><c:out value="${curManagerReport.location}"></c:out></td>
		            <td><c:out value="${curManagerReport.revenue}"></c:out></td>
		          	</tr>
		          </c:forEach>
			    </tbody>
				</table>
	   		</div>
    	</div>	
    </jsp:body>
</t:template>