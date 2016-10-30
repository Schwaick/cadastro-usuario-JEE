package com.shay.factory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shay.beans.Usuario;
import com.shay.jdbc.UsuarioDAO;

public class Alterar {
	private Usuario usuario;
	
	public Alterar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void processa(HttpServletRequest request, HttpServletResponse response, 
			UsuarioDAO usuarioDAO) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		usuario.setId(id);
		
		if(usuario.getLogin() == null || usuario.getLogin().length() <= 0) {
			usuario.setLogin(usuarioDAO.buscar(id).getLogin());
		}
		if(usuario.getSenha() == null || usuario.getSenha().length() <= 0) {
			usuario.setSenha(usuarioDAO.buscar(id).getSenha());
		}
		if(usuario.getNome() == null || usuario.getNome().length() <= 0) {
			usuario.setNome(usuarioDAO.buscar(id).getNome());
		}
		if(usuario.getTipo() == null) {
			usuario.setTipo("Aluno");
		}
		
		String mensagem = "";
		
		if(usuarioDAO.alterar(usuario)) {
			mensagem = "Usuario "+usuario.getNome()+" alterado com sucesso!!";
		} else {
			mensagem = "Erro ao alterar o usuario "+usuario.getNome()+"!!";
		}
		
		if(((Usuario) request.getSession().getAttribute("usuario")).getId() != id) {
			request.setAttribute("msg", mensagem);
			request.setAttribute("tipo", usuarioDAO.buscar(id).getTipo());
			new Listar().processa(request, response, usuarioDAO);
		} else {
			response.sendRedirect("alterar.jsp?msg="+mensagem);
		}	
	}
}
