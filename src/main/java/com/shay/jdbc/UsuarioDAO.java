package com.shay.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shay.beans.Usuario;
import com.shay.interfaces.UsuarioInterface;

public class UsuarioDAO implements UsuarioInterface{

	private Connection connection;
	private static final String NOME_BANCO = "faculteste";
	private static final String USUARIO = "igor";
	private static final String SENHA = "15935769";
	private static final String TABELA = "usuarios";
	
	public UsuarioDAO() {
		connection = Connect.getConnection(NOME_BANCO, USUARIO, SENHA);
	}
	
	@Override
	public boolean inserir(Usuario usuario) {
		if(connection != null) {		
			try {
				String sql = "INSERT INTO "+TABELA+" (nome,login,senha) VALUES (?,?,?)";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, usuario.getNome());
				statement.setString(2, usuario.getLogin());
				statement.setString(3, usuario.getSenha());
				
				statement.execute();
				statement.close();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
				
		} else {
			return false;
		}
		
	}

	@Override
	public boolean alterar(Usuario usuario) {
		if(connection != null) {		
			try {
				String sql = "UPDATE "+TABELA+" SET nome=?,login=?,senha=?,tipo=?,nivel_acesso=? WHERE id=?";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, usuario.getNome());
				statement.setString(2, usuario.getLogin());
				statement.setString(3, usuario.getSenha());
				statement.setString(4, usuario.getTipo());
				statement.setInt(5, usuario.getNivelAcesso());
				statement.setInt(6, usuario.getId());
				
				statement.execute();
				statement.close();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
				
		} else {
			return false;
		}
	}

	@Override
	public Usuario buscar(Usuario usuario) {
		
		if(connection != null) {		
			try {
				String sql = "SELECT * FROM "+TABELA+" WHERE login=? AND senha=?";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, usuario.getLogin());
				statement.setString(2, usuario.getSenha());
				
				ResultSet result = statement.executeQuery();
				if(result.first()) {
					Usuario usuarioBuscado = new Usuario();
					usuarioBuscado.setId(result.getInt("id"));
					usuarioBuscado.setLogin(result.getString("login"));
					usuarioBuscado.setNome(result.getString("nome"));
					usuarioBuscado.setSenha(result.getString("senha"));
					usuarioBuscado.setTipo(result.getString("tipo"));
					usuarioBuscado.setNivelAcesso(result.getInt("nivel_acesso"));
					
					statement.close();
					return usuarioBuscado;

				} else {
					statement.close();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
				
		} else {
			return null;
		}
		
	}
	
	@Override
	public Usuario buscar(int id) {
		
		if(connection != null) {		
			try {
				String sql = "SELECT * FROM "+TABELA+" WHERE id=?";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setInt(1, id);
				
				ResultSet result = statement.executeQuery();
				if(result.first()) {
					Usuario usuarioBuscado = new Usuario();
					usuarioBuscado.setId(result.getInt("id"));
					usuarioBuscado.setLogin(result.getString("login"));
					usuarioBuscado.setNome(result.getString("nome"));
					usuarioBuscado.setSenha(result.getString("senha"));
					usuarioBuscado.setTipo(result.getString("tipo"));
					usuarioBuscado.setNivelAcesso(result.getInt("nivel_acesso"));
					
					statement.close();
					return usuarioBuscado;

				} else {
					statement.close();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
				
		} else {
			return null;
		}
		
	}
	
	@Override
	public boolean verificarCadastro(String login) {
		if(connection != null) {		
			try {
				String sql = "SELECT * FROM "+TABELA+" WHERE login=?";
				
				PreparedStatement statement = connection.prepareStatement(sql);			
				statement.setString(1, login);
				
				ResultSet result = statement.executeQuery();
				if(result.first()) {	
					statement.close();
					return true;
				} else {
					statement.close();
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return true;
			}
				
		} else {
			return true;
		}
	}

	@Override
	public List<Usuario> listar(String tipo) {
		if(connection != null) {		
			try {
				String sql = "SELECT * FROM "+TABELA+" WHERE tipo=?";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, tipo);
				
				ResultSet result = statement.executeQuery();
				List<Usuario> lista = new ArrayList<Usuario>();
				while(result.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(result.getInt("id"));
					usuario.setNome(result.getString("nome"));
					usuario.setLogin(result.getString("login"));
					usuario.setSenha(result.getString("senha"));
					usuario.setTipo(result.getString("tipo"));
					usuario.setNivelAcesso(result.getInt("nivel_acesso"));
					
					lista.add(usuario);
				}
				
				statement.close();
				return lista;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
				
		} else {
			return null;
		}
	}

	@Override
	public boolean excluir(int id) {
		if(connection != null) {		
			try {
				String sql = "DELETE FROM "+TABELA+" WHERE id=?";
				
				PreparedStatement statement = connection.prepareStatement(sql);			
				statement.setInt(1, id);
				
				statement.execute();
				statement.close();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
				
		} else {
			return false;
		}
	}
	
}
