<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Página principal</title>
	<link rel="stylesheet" type="text/css" href="css/principal.css"/>
</head>
<body>
	<div id="tudo">
		<c:import url="partes/cabecalho.jsp" />
		<c:import url="partes/menu.jsp" />
		<div id="conteudo">
		
			<div align="center">
				<h1><i>
					<c:choose>
						<c:when test="${!empty sessionScope.usuario}">
							Logado com sucesso!!		
						</c:when>
						<c:otherwise>
							Bem-vindo ao sistema!!
						</c:otherwise>
					</c:choose>
				</i></h1>
				<br/><br/>
				<img alt="HUEHUEHUE" src="imagens/computacao.gif" />
			</div>
		</div>
		<c:import url="partes/rodape.jsp" />
	</div>
</body>
</html>