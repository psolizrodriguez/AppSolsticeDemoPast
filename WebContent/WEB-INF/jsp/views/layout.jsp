<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link href="jquery-ui-1.12.1/jquery-ui.css" rel="stylesheet">
<script src="<c:url value="/jquery-ui-1.12.1/external/jquery/jquery.js" />"></script>
<script src="jquery-ui-1.12.1/jquery-ui.js"></script>
<link type="text/css" rel="stylesheet" href="<c:url value="/styles/main.css" />" />
<script src="<c:url value="/scripts/index.js" />"></script>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<main> <tiles:insertAttribute name="body" /></main>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>