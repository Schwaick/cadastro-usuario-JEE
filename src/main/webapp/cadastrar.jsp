<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="minhatag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastrar</title>
	<link rel="stylesheet" type="text/css" href="css/principal.css"/>
	<script type="text/javascript" src="scripts/principal.js"></script>
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

				<form action="UserController.do?action=cadastrar" method="post">
					<fieldset style="width: 50%;">
						<legend title="Titulo Fieldset" style="font-size: 20px;">
							<b><i>Cadastrar</i></b>
						</legend>
						<table>
							<minhatag:input name="nome" label="Nome:" type="text" id="nome" />
							<minhatag:input name="login" label="Login:" type="text" id="login" />
							<minhatag:input name="senha" label="Senha:" type="password" id="senha" />
							<minhatag:botoes nameConfirm="confirmar" valueCancel="Cancelar" 
								nameCancel="cancelar" valueConfirm="Confirmar"
								 method="validarCampos();" />
						</table>
					</fieldset>
				</form>
			</div>
			
		</div><!-- Fim conteudo -->
		<c:import url="partes/rodape.jsp" />
	</div>
</body>
</html>