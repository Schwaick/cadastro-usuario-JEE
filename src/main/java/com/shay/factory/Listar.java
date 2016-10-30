package com.shay.factory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shay.jdbc.UsuarioDAO;

public class Listar {
	public void processa(HttpServletRequest request, HttpServletResponse response, 
			UsuarioDAO usuarioDAO) throws ServletException, IOException {
		
		String tipoParam = request.getParameter("tipo");
		String tipoAtri = (String) request.getAttribute("tipo");
		
		if(tipoAtri != null) {
			request.setAttribute("lista", usuarioDAO.listar(tipoAtri));
			if(tipoAtri.equals("Aluno")) {
				request.getRequestDispatcher("listal.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("listpro.jsp").forward(request, response);
			}
		}
		
		request.setAttribute("lista", usuarioDAO.listar(tipoParam));
		if(tipoParam.equals("Aluno")) 
			request.getRequestDispatcher("listal.jsp").forward(request, response);
		else
			request.getRequestDispatcher("listpro.jsp").forward(request, response);
		
	}
}
