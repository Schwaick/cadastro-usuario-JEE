package com.shay.interfaces;

import java.util.List;

import com.shay.beans.Usuario;

public interface UsuarioInterface {
	public boolean inserir(Usuario usuario);
	public boolean alterar(Usuario usuario);
	public Usuario buscar(Usuario usuario);
	public Usuario buscar(int id);
	public boolean verificarCadastro(String login);
	public List<Usuario> listar(String tipo);
	public boolean excluir(int id);
}
