<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>

    <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Log in</h2>
    		</div>
    		<form  action="login" method="POST">
	    		<div class="panel-body">
	    			<div class="input-group">
	    				<input type="text" class="form-control" name="username" placeholder="username"/>
	   				</div>
	   				<br>
	    			<div class="input-group">
				      <input type="password" class="form-control" name="password" placeholder="password">
				      <div class="input-group-btn">
				        <button class="btn btn-default" type="submit">Go!</button>
				      </div>
				    </div>
				    
				    <br>
				    <a href="<c:url value="/newUser"/>" role="button" class="btn btn-default pull-right" >Register</a>
	    		</div>
    		</form>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    	
    </jsp:body>
</t:template>