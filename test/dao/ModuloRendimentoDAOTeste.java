package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import service.Categoria;

public class ModuloRendimentoDAOTeste {
	
	public static void cadastrarNovaCategoria() throws SQLException, IOException{
		
		Categoria categoria = new Categoria();
		categoria.setCategoria("Venda");
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).cadastrarNovaCategoria(categoria);
		
		System.out.println("Categoria cadastrada com sucesso.");
	}
	
	public static void editarCategoria() throws SQLException, IOException {
			
			Categoria categoria = new Categoria();
			categoria.setCategoria("Teste");
			categoria.setCategoria_id(2);
			Connection conn = BancoDados.conectar();
			new ModuloRendimentoDAO(conn).editarCategoria(categoria);
			
			System.out.println("Categoria editada com sucesso.");
		}
	
	public static void excluirCategoria() throws SQLException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setCategoria("Teste");
		categoria.setCategoria_id(2);
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).excluirCategoria(categoria);
		
		System.out.println("Categoria excluido com sucesso.");
	}
	
	public static void cadastrarNovoRendimento() throws SQLException, IOException {
		
	}
	
	public static void editarRendimento() throws SQLException, IOException {
		
	}
	
	public static void excluirDespesa() throws SQLException, IOException {
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			ModuloRendimentoDAOTeste.excluirCategoria();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
}
