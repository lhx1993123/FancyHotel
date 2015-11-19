<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="edu.gatech.cs4400.FancyHotel.Controller.ParameterNames"%>
<t:template>
    <jsp:body>
       	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Give Review </h2>
    		</div>
	   		<div class="panel-body">
					<form action="generateReview" method="POST">
						<h3>Hotel Location: </h3><span class="label label-default"></span>
							<input list="locations" name="location">
							  <datalist id="locations">
							    <option value="Atlanta">
							    <option value="Charlotte">
							    <option value="Savannah">
							    <option value="Orlando">
							    <option value="Miami">
							  </datalist> <br>
						
						<h3>Rating: </h3><span class="label label-default"></span>
							<input list="ratings" name="rating">
							  <datalist id="ratings">
							    <option value="Excellent">
							    <option value="Good">
							    <option value="Bad">
							    <option value="Very Bad">
							    <option value="Neutral">
							  </datalist> <br>						
						
						<h3>Leave a comment: </h3><span class="label label-default"></span>
						<input type="text" class="form-control" name="comment" placeholder="comment" aria-describedby="basic-addon2"><br><br>
						
						<button class="btn btn-default pull-right" type="submit">Submit</button><br>
					</form>
	   		</div>
    	</div>				
    </jsp:body>
</t:template>