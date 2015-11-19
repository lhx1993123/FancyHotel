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
				<h3>Hotel Location: </h3><span class="label label-default"></span>
					<input list="ratings" name="rating">
					  <datalist id="ratings">
					    <option value="Excellent">
					    <option value="Good">
					    <option value="Bad">
					    <option value="Very Bad">
					    <option value="Neutral">
					  </datalist>
				<br>
				<a href="<c:url value="/newUser"/>" role="button" class="btn btn-default pull-right" >Check Reviews</a><br><br>
				<hr>
				
				<c:if test="${not empty errorMessage}">
	    			<table class="table">
				   	<thead>
					    <tr>
					    <th>Rating</th>
					    <th>Comment</th>
					    </tr>
					</thead>
				    <tbody>
					    <tr>
					    <td>Excellent</td>
					    <td>Very Bad</td>
					    </tr>
					    <tr>
					    <td>Awesome</td>
					    <td>WTH</td>
					    </tr>
				    </tbody>
					</table>
	   			</c:if>
	   		</div>
	   		
	   		
    	</div>
		
    </jsp:body>
</t:template>