<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="edu.gatech.cs4400.FancyHotel.Controller.ParameterNames"%>
<t:template>
    <jsp:body>
    
       	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>New User Registration</h2>
    		</div>
	   		<div class="panel-body">
				<h3>Hotel Location </h3><span class="label label-default"></span>
		   		<div class="dropdown">
				  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				    Choose a location
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="<c:url value='/getReview?location=Atlanta'">Atlanta</a></li>
				    <li><a href="#">Charlotte</a></li>
				    <li><a href="#">Savannah</a></li>
				    <li><a href="#">Orlanda</a></li>
				    <li><a href="#">Miami</a></li>
				  </ul>
				</div>
				
				
				<a href="<c:url value="/newUser"/>" role="button" class="btn btn-default pull-right" >Check Reviews</a>	   	
	   		</div>
	   		
	   		
    	</div>
		
		<hr>
		
    </jsp:body>
</t:template>