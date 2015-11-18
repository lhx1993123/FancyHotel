<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Add Card</h2>
    		</div>
    		<form  action="card info" method="POST">
	    		<div class="panel-body">
	    			<input type="text" class="form-control" name="nameonCard" placeholder="Name on Card" aria-describedby="basic-addon3">
	   				<br>
	    			<input type="text" class="form-control" name="cardNumber" placeholder="Card Number" aria-describedby="basic-addon3">
					<br>
					<input type="password" class="form-control" name="expireDate" placeholder="Expiration Date" aria-describedby="basic-addon3">
				    <br>
				    <input type="password" class="form-control" name="cvv" placeholder="Cvv" aria-describedby="basic-addon3">
				    <br>
				    <button class="btn btn-default pull-right" type="save">Save</button>
	    		</div>
    		</form>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    	
    </jsp:body>
</t:template>