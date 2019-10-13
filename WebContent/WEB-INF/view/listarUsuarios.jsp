<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listar usuários</title>
	</head>
	
	<body>
		<c:forEach items="${usuarios}" var="usuario">
			${usuario.login} <br/>
		</c:forEach>
	</body>
</html>