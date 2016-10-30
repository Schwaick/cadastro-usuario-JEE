<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="menu">
	<h2>Menu</h2>
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<c:choose>
			<c:when test="${!empty sessionScope.usuario}">
				<li><a href="UserController.do?action=listar&tipo=Aluno">Lista de alunos</a></li>
				<li><a href="UserController.do?action=listar&tipo=Professor">Lista de professores</a></li>
				<li><a href="alterar.jsp?userid=${sessionScope.usuario.id}">Alterar meus dados</a></li>
				<li class="last-li"><a href="UserController.do?action=deslogar">Deslogar</a></li>	
			</c:when>
			<c:otherwise>
				<li><a href="cadastrar.jsp">Cadastrar</a></li>
				<li class="last-li"><a href="logar.jsp">Logar</a></li>
			</c:otherwise>
		</c:choose>	
	</ul>
</div>
