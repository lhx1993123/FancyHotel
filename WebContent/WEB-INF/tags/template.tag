<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel="icon" href="../../favicon.ico">

    <title>Fancy Hotel</title>
    <link href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/css/index.css"/>" type="text/css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<c:url value="/"/>">Fancy Hotel</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<c:url value="/"/>">Home</a></li>
            <li><a href="<c:url value="/about"/>">About</a></li>
          </ul>
        </div>
      </div>
    </nav>
	<div class="container">
	  <div id="body">
		<jsp:doBody/>
	  </div>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="<c:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"/>"></script>
  </body>
</html>