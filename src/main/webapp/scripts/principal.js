function validarCampos() {
	
	var nome = document.getElementById("nome");
	var login = document.getElementById("login");
	var senha = document.getElementById("senha");
	
	var msg = "";

	if(nome != null && nome.value.toString().length < 3) {
		msg = "O nome deve ter no m&iacute;nimo 3 caracteres;<br>";
	}
	if(login != null && login.value.toString().length < 4) {
		msg += "O login deve ter no m&iacute;nimo 4 caracteres;<br>";
	}
	if(senha != null && senha.value.toString().length < 4) {
		msg += "A senha deve ter no m&iacute;nimo 4 caracteres;";
	}
	
	if(msg != "") {
		document.getElementById("mensagem").innerHTML = 
			"<span>" + msg + "</span>";
		window.event.preventDefault();
		return false;
	} else {
		return true;
	}
		
}