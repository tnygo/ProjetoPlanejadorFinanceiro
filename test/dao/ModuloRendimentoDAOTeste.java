package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import service.Categoria;
import service.Investimento;
import service.Rendimento;

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
		
		Categoria categoria = new Categoria();
		categoria.setCategoria_id(1);
		Rendimento rendimento = new Rendimento();
		rendimento.setCategoria(categoria);
		rendimento.setRendimento("Salário");
		rendimento.setValorMensal(3000);
		rendimento.setValorOcasional(0);
		rendimento.setValorTotal(20000);
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).cadastrarRendimento(rendimento);
		
		System.out.println("Rendimento cadastrado com sucesso.");
	}
	
	public static void editarRendimento() throws SQLException, IOException {
		
		Rendimento rendimento = new Rendimento();
		rendimento.setRendimento("Aluguel");
		rendimento.setRendimento_id(1);
		rendimento.setCategoria_id(3);
		rendimento.setValorMensal(1000);
		rendimento.setValorOcasional(0);
		rendimento.setValorTotal(2000);
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).editarRendimento(rendimento);
		
		System.out.println("Rendimento editado com sucesso.");
	}
	
	public static void excluirRendimento() throws SQLException, IOException {
		
		Rendimento rendimento = new Rendimento();
		rendimento.setRendimento_id(1);
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).excluirRendimento(rendimento);
		
		System.out.println("Rendimento excluido com sucesso.");
	}
	
	public static void main(String[] args) {
		
		try {
			
			ModuloRendimentoDAOTeste.excluirRendimento();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
}
