<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
		<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>View Review </h2>
    		</div>
	   		<div class="panel-body">
				<span>Reservation ID: </span>
				<span>12134 </span><br><br>
				<span>Start Date: </h3><span class="label label-default"></span><br><br>
				<span>End Date: </h3><span class="label label-default"></span><br><br>
				
				<div class="bs-example" data-example-id="table-within-panel">
				    <div class="panel panel-default">
				      <!-- Default panel contents -->
				      <table class="table">
				        <thead>
				          <tr>
				            <th>Room number</th>
				            <th>Room category</th>
				            <th>#person allowed</th>
				           	<th>Cost per day</th>
				            <th>cost of extra bed per day</th>
				            <th>Select extra bed</th>
				          </tr>
				        </thead>
				        <tbody>
				          <tr>
				            <td>1</td>
				          </tr>
				          <tr>
				            <td>2</td>
				          </tr>
				          <tr>
				            <td>3</td>
				          </tr>
				        </tbody>
				      </table>
			    </div>
			  	</div>
			  	
			  	<span>Total Cost of Reservation:</span><br><br>
				<span>Date of Cancellation:</span><br><br>
				<span>Amount to be refunded:</span><br><br>
				<a href="<c:url value="/newUser"/>" role="button" class="btn btn-default pull-right" >Cancel</a>
	   		</div>
    	</div>
    </jsp:body>
</t:template>