<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
   <jsp:body>
    	<div class="panel panel-info">
    		<div class="panel-heading">
    			<h2>Rooms are available. Please confirm details below before submitting.</h2>
    		</div>
    		<form  action="login" method="POST">
	    		<div class="panel-body">
	    			<table class="table">
			            <thead>
			              <tr>
			                <th>Room number</th>
			                <th>Room Category</th>
			                <th>#Persons allowed</th>
			                <th>Cost per day</th>
			                <th>Cost of extra bed per day</th>
			                <th>Select extra bed</th>
			              </tr>
			            </thead>
			            <tbody>
			              <tr>
			                <td>1</td>
			                <td>Family</td>
			                <td>4</td>
			                <td>170</td>
			                <td>50</td>
			                <td><input type="checkbox" name="Yes"><BR></td>
			              </tr>
			              <tr>
			                <td>2</td>
			                <td>Standard</td>
			                <td>2</td>
			                <td>100</td>
			                <td>70</td>
			                <td><input type="checkbox" name="Yes"><BR></td>
			              </tr>
			              <tr>
			                <td>3</td>
			                <td>Standard</td>
			                <td>2</td>
			                <td>100</td>
			                <td>70</td>
			                <td><input type="checkbox" name="Yes"><BR></td>
			              </tr>
			            </tbody>
			          </table>
			        <p>Total Cost Updated:<p>
				    <button class="btn btn-default pull-right" type="submit">Update</button>
	    		</div>
    		</form>
    	</div>
    	<c:if test="${not empty errorMessage}">
	    	<div class="alert alert-warning" role="alert">${errorMessage}</div>
	    </c:if>
    </jsp:body>
</t:template>