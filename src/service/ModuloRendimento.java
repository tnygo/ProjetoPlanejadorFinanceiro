package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ModuloDespesasDAO;
import dao.ModuloRendimentoDAO;

public class ModuloRendimento {

	public void cadastrarNovaCategoria(Categoria categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).cadastrarNovaCategoria(categoria);
	}
	
	public void editarCategoria(Categoria categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).editarCategoria(categoria);
	}
	
	public void excluirCategoria(Categoria categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).excluirCategoria(categoria);
	}
	
	public void cadastrarNovoRendimento(Rendimento rendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).cadastrarRendimento(rendimento);
	}
	
	public void editarRendimento(Rendimento rendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).editarRendimento(rendimento);
	}
	
	public void excluirRendimento(Rendimento rendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloRendimentoDAO(conn).excluirRendimento(rendimento);
	}

	public List<Categoria> buscarCategoria() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new ModuloRendimentoDAO(conn).buscarCategoria();
		
	}
	public List<Rendimento> buscarRendimento() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new ModuloRendimentoDAO(conn).buscarRendimento();
	}
}
