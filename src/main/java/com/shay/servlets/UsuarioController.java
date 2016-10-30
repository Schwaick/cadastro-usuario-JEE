package com.shay.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shay.beans.Usuario;
import com.shay.factory.Alterar;
import com.shay.factory.Cadastrar;
import com.shay.factory.Excluir;
import com.shay.factory.Listar;
import com.shay.factory.Logar;
import com.shay.jdbc.UsuarioDAO;

@WebServlet("/UserController.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executar(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executar(request, response);
	}
	
	private void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setTipo(request.getParameter("tipo"));
		usuario.setNivelAcesso(Integer.parseInt(
				request.getParameter("nivelAcesso") == null ? "0" : request.getParameter("nivelAcesso")
		));
		
		if(action != null && action.equals("cadastrar")) {			
			new Cadastrar(usuario).processa(request, response, usuarioDAO);
		}
		
		if(action != null && action.equals("logar")) {	
			new Logar(usuario).processa(request, response, usuarioDAO);
		}
		
		if(action != null && action.equals("alterar")) {			
			new Alterar(usuario).processa(request, response, usuarioDAO);
		}
		
		if(action != null && action.equals("listar")) {
			new Listar().processa(request, response, usuarioDAO);
		}
		
		if(action != null && action.equals("excluir")) {
			new Excluir().processa(request, response, usuarioDAO);
		}
		
		if(action != null && action.equals("deslogar")) {
			request.getSession().removeAttribute("usuario");
			response.sendRedirect("index.jsp");
		}
		
	}

}
