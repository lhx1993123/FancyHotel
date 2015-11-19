<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="edu.gatech.cs4400.FancyHotel.Controller.ParameterNames"%>
<t:template>
    <jsp:body>
		<h3>Hotel Location </h3><span class="label label-default"></span>
   		<div class="dropdown">
		  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    Choose a location
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		    <li><a href="#">Atlanta</a></li>
		    <li><a href="#">Charlotte</a></li>
		    <li><a href="#">Savannah</a></li>
		    <li><a href="#">Orlanda</a></li>
		    <li><a href="#">Miami</a></li>
		  </ul>
		</div>
		
		<h3>Rating </h3><span class="label label-default"></span>
   		<div class="dropdown">
		  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    Choose a location
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		    <li><a href="#">Excellent</a></li>
		    <li><a href="#">Good</a></li>
		    <li><a href="#">Bad</a></li>
		    <li><a href="#">Very Bad</a></li>
		    <li><a href="#">Neutral</a></li>
		  </ul>
		</div>		
    </jsp:body>
</t:template>