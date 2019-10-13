<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<c:if test="${not empty errorMessage}">
			<c:import url="errorMessage.jsp" />
		</c:if>
		<form action="/controlador/loginForm" method="post">
			Login: <input type="text" name="login"  />
			<br/><br/>
			Senha: <input type="password" name="senha" />
		
			<br/><br/>
		
			<input type="submit" />
		</form>
	
	</body>
</html>