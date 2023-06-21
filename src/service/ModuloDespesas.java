package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ModuloDespesasDAO;
import dao.ModuloRendimentoDAO;

public class ModuloDespesas {


	public void cadastrarNovaCategoria(Categoria categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).cadastrarNovaCategoria(categoria);
	}

	public void editarCategoria(Categoria categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).editarCategoria(categoria);
	}
	
	public void excluirCategoria(Categoria categoria) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).excluirCategoria(categoria);
		
	}
	
	public void cadastrarNovaDespesa(Despesa despesa) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).cadastrarNovaDespesa(despesa);
	}
	
	public void editarDespesa(Despesa despesa) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).editarDespesa(despesa);
	}
	
	public void excluirDespesa(Despesa despesa) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).excluirDespesa(despesa);
	}
	
	public List<Categoria> buscarCategoria() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new ModuloDespesasDAO(conn).buscarCategoria();
		
	}

	public List<Despesa> buscarDespesa() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new ModuloDespesasDAO(conn).buscarDespesa();
	}
}
