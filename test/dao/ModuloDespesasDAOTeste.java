package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import service.Categoria;
import service.Despesa;

public class ModuloDespesasDAOTeste {

	public static void cadastrarNovaCategoria() throws SQLException, IOException{
		
		Categoria categoria = new Categoria();
		categoria.setCategoria("Moradia");
		
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).cadastrarNovaCategoria(categoria);
		
		System.out.println("Categoria cadastrada com sucesso.");
	}
	/*
	public static void buscarCategoria() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Categoria> listaCategoria = new ModuloDespesasDAO(conn).buscarCategoria();
		
		for (Categoria categoria : listaCategoria) {
			
			System.out.println(categoria.getCategoria_id() + "-" + categoria.getCategoria());
		}
	}
	*/
	public static void editarCategoria() throws SQLException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setCategoria("Teste");
		categoria.setCategoria_id(1);
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).editarCategoria(categoria);
		
		System.out.println("Categoria editada com sucesso.");
	}
	
	public static void excluirCategoria() throws SQLException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setCategoria("Teste");
		categoria.setCategoria_id(1);
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).excluirCategoria(categoria);
		
		System.out.println("Categoria excluido com sucesso.");
	}
	
	public static void cadastrarDespesa() throws SQLException, IOException{
		
		Categoria categoria = new Categoria();
		categoria.setCategoria_id(2);
		Despesa despesa = new Despesa();
		despesa.setCategoria(categoria);
		despesa.setDespesa("Combustível");
		despesa.setValorMensal(800);
		despesa.setValorOcasional(0);
		despesa.setValorTotal(800*12);
		
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).cadastrarNovaDespesa(despesa);
		
		System.out.println("Despesa cadastrada com sucesso.");
	}
		
	public static void editarDespesa() throws SQLException, IOException {
			
			Despesa despesa = new Despesa();
			despesa.setDespesa("IPVA");
			despesa.setDespesa_id(1);
			despesa.setCategoria_id(2);
			despesa.setValorMensal(900);
			despesa.setValorOcasional(1);
			despesa.setValorTotal(11000);
			
			Connection conn = BancoDados.conectar();
			new ModuloDespesasDAO(conn).editarDespesa(despesa);
			
			System.out.println("Despesa editada com sucesso.");
		}
	
	public static void excluirDespesa() throws SQLException, IOException {
		
		Despesa despesa = new Despesa();
		despesa.setDespesa_id(1);
		
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).excluirDespesa(despesa);
		
		System.out.println("Despesa excluido com sucesso.");
	}
	
	public static void main(String[] args) {
		
		try {
			
			ModuloDespesasDAOTeste.cadastrarNovaCategoria();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
