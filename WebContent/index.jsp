<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>

    <jsp:body>
    	<div class="panel panel-default">
    		<div class="panel-heading">
    			<h2>Log in</h2>
    		</div>
    		<div class="panel-body">
    			<div class="input-group">
    				<input type="text" class="form-control" placeholder="username"/>
   				</div>
   				<br>
    			<div class="input-group">
			      <input type="password" class="form-control" placeholder="password">
			      <div class="input-group-btn">
			        <button class="btn btn-default" type="button">Go!</button>
			      </div>
			    </div>
			    <br>
			    <button type="button" class="btn btn-default pull-right">Register</button>
    		</div>
    	</div>
    	
    </jsp:body>
</t:template>