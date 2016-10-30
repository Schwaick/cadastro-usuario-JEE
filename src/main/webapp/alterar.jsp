<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="minhatag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alterar Dados</title>
	<link rel="stylesheet" type="text/css" href="css/principal.css"/>
</head>
<body>
	<div id="tudo">
		<c:import url="partes/cabecalho.jsp" />
		<c:import url="partes/menu.jsp" />
		<div id="conteudo">
		
			<div align="center">
			
				<div id="mensagem">
					<c:if test="${!empty param.msg}">
						<span>${param.msg}</span>
					</c:if>
				</div>
			
				<form action="UserController.do?action=alterar" method="post">
					<fieldset style="width: 50%;">
						<legend title="Titulo Fieldset" style="font-size: 20px;">
							<b><i>Alterar Dados</i></b>
						</legend>
						<input type="hidden" name="id" value="${param.userid}" />
						<table>
							<minhatag:input name="nome" label="Nome:"
								type="text" id="nome" />
							<minhatag:input name="login" label="Login:" 
								type="text" id="login" />
							<minhatag:input name="senha" label="Senha:" 
								type="password" id="senha" />
								
							<c:if test="${sessionScope.usuario.nivelAcesso == 2}">
								<tr><td></td><td><span style="color:red;">*Os dados tipo e root são obrigatórios.</span></td></tr>
								<minhatag:dropbox value2="Professor" value1="Aluno" label="Tipo:" 
									name="tipo" lblvalue2="Professor" lblvalue1="Aluno" 
									value3="ADM" lblvalue3="ADM"/>
								<minhatag:dropbox value2="1" value1="0" label="Root?"
									name="nivelAcesso" lblvalue2="1" lblvalue1="0"
									value3="2" lblvalue3="2" />
							</c:if>
							
							<minhatag:botoes nameConfirm="confirmar" valueCancel="Cancelar" 
								nameCancel="cancelar" valueConfirm="Confirmar" />
						</table>
					</fieldset>
				</form>
			</div>
			
		</div>
		<c:import url="partes/rodape.jsp" />
	</div>
</body>
</html>