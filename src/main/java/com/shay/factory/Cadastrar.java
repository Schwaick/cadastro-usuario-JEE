package com.shay.factory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shay.beans.Usuario;
import com.shay.jdbc.UsuarioDAO;

public class Cadastrar {
	
	private Usuario usuario;
	
	public Cadastrar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void processa(HttpServletRequest request, HttpServletResponse response, 
			UsuarioDAO usuarioDAO) throws ServletException, IOException {
		
		if(usuarioDAO.verificarCadastro(usuario.getLogin()) == false) {
			String mensagem = "";
			if(usuarioDAO.inserir(usuario)) {
				mensagem = "Cadastrado com sucesso!!";
				response.sendRedirect("cadastrar.jsp?msg="+mensagem);
			} else {
				mensagem = "Erro ao cadastrar!!";
				response.sendRedirect("cadastrar.jsp?msg="+mensagem);
			}
		} else {	
			String mensagem = "Usuario ja cadastrado!!";	
			response.sendRedirect("cadastrar.jsp?msg="+mensagem);
		}
		
	}
}
