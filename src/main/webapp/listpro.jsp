<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de professores</title>
	<link rel="stylesheet" type="text/css" href="css/principal.css"/>
</head>
<body>
	<div id="tudo">
		<c:import url="partes/cabecalho.jsp" />
		<c:import url="partes/menu.jsp" />
		<div id="conteudo">
		
			<div align="center">
			
				<div id="mensagem">
					<c:if test="${!empty requestScope.msg}">
						<span>${requestScope.msg}</span>
					</c:if>
				</div>
			
				<c:if test="${!empty requestScope.lista}">
					<table border="1" style="text-align:center;" width="500px">
						<tr style="background-color:black;color:white;">
							<th>ID</th>
							<th>Nome</th>
							<th>Login</th>
							<th>Senha</th>
							<c:if test="${sessionScope.usuario.nivelAcesso == 2}">
								<th>Tipo</th>
								<th>Nivel</th>
							</c:if>
							<c:if test="${sessionScope.usuario.nivelAcesso > 0}">
								<th>Alterar</th>
								<th>Excluir</th>
							</c:if>
						</tr>
						<c:forEach var="professor" items="${requestScope.lista}" varStatus="id">
							<tr bgColor="${id.count%2==0? '#c9c9c9' : '#ffffff'}">
								<td>${professor.id}</td>
								<td>${professor.nome}</td>
								<td>${professor.login}</td>
								<td>${professor.senha}</td>
								<c:if test="${sessionScope.usuario.nivelAcesso == 2}">
									<td>${professor.tipo}</td>
									<td>${professor.nivelAcesso}</td>
								</c:if>
								<c:if test="${sessionScope.usuario.nivelAcesso > 0}">
									<td><a href="alterar.jsp?userid=${professor.id}">Alterar</a></td>
									<td><a href="UserController.do?action=excluir&id=${professor.id}&tipo=Professor">
										Excluir</a>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${empty requestScope.lista}">
					<span><b>Nenhum professor encontrado :/</b></span>
				</c:if>
			</div>
			
		</div>
		<c:import url="partes/rodape.jsp" />
	</div>
</body>
</html>