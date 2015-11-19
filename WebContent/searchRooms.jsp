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
    			<form action="searchRooms">
    				<h3>Location: </h3>
					<input list="locations" name="location">
					  <datalist id="locations">
					    <option value="Atlanta">
					    <option value="Charlotte">
					    <option value="Savannah">
					    <option value="Orlando">
					    <option value="Miami">
					  </datalist>
					<br>
					<h3>Start Date: </h3>
					<input type="date" name="startdate">
					<br>
					<h3>End Date: </h3>
					<input type="date" name="enddate">
					<button class="btn btn-default pull-right" type="submit">Search</button>
				</form>
    		</div>
    	</div>
    </jsp:body>
    
</t:template>

