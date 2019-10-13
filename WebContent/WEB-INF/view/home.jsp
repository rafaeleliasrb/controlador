<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home Page</title>
	</head>
	
	<body>
		<c:import url="logout.jsp" />
		
		Bem vindo ${usuarioLogado.login}
		
		<br/>
		<br/>
		
		<a href="/controlador/ListarUsuarios">Listar usuários</a>
	</body>
</html>