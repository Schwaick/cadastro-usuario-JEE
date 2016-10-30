package com.shay.factory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shay.beans.Usuario;
import com.shay.jdbc.UsuarioDAO;

public class Logar {
	
	private Usuario usuario;
	
	public Logar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void processa(HttpServletRequest request, HttpServletResponse response, 
			UsuarioDAO usuarioDAO) throws ServletException, IOException {
		
		if((usuario = usuarioDAO.buscar(usuario)) != null) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("index.jsp");
		} else {				
			String mensagem = "Usuario nao encontrado!!";
			response.sendRedirect("logar.jsp?msg="+mensagem);
		}
		
	}
}
