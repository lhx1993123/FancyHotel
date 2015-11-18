<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
        <div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Choose Functionality</h2>
    		</div>
    		<div class="panel-body">
				<h3><c:out value="Welcome ${user.username},"/></h3>
				<c:if test="${user.userType=='user'}">
	    			<div class="btn-group-vertical center-block" role="group">
					  <a role="button" class="btn btn-default">Make a new reservation</a>
					  <a role="button" class="btn btn-default">Update your reservation</a>
					  <a role="button" class="btn btn-default">Cancel reservation</a>
					  <a role="button" class="btn btn-default">Provide feedback</a>
					  <a role="button" class="btn btn-default">View feedback</a>
					</div>
				
				</c:if>
				<c:if test="${user.userType=='manager'}">
					<div class="btn-group-vertical center-block" role="group">
					  <a role="button" class="btn btn-default">View Reservation Report</a>
					  <a role="button" class="btn btn-default">View popular room category report</a>
					  <a role="button" class="btn btn-default">View revenue report</a>
					</div>
				</c:if>
    		</div>
    	</div>
    </jsp:body>
</t:template>