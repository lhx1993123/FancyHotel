<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
    <span>Reservation ID </span>
	<span>12134 </span><br>
	<span>Start Date </h3><span class="label label-default"></span><br>
	<span>End Date </h3><span class="label label-default"></span>
	
	<div class="bs-example" data-example-id="table-within-panel">
	    <div class="panel panel-default">
	      <!-- Default panel contents -->

	      <!-- Table -->
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
  	
  	<h3>Total Cost of Reservation </h3><span class="label label-default"></span>
	<h3>Date of Cancellation </h3><span class="label label-default"></span>
	<h3>Amount to be refunded </h3><span class="label label-default"></span>
	<a href="<c:url value="/newUser"/>" role="button" class="btn btn-default pull-center" >Cancel</a>
  	

    </jsp:body>
</t:template>