package com.shay.factory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shay.jdbc.UsuarioDAO;

public class Excluir {
	public void processa(HttpServletRequest request, HttpServletResponse response, 
			UsuarioDAO usuarioDAO) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(usuarioDAO.excluir(id)) {
			request.setAttribute("msg", "Usuario de id=" + id + " foi excluido!!");
			new Listar().processa(request, response, usuarioDAO);
		}
		
	}
}
