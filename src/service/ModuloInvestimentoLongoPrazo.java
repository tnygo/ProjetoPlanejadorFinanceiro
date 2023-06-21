package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ModuloFundoInvestimentoLongoPrazoDAO;

public class ModuloInvestimentoLongoPrazo {

	public void cadastrarNovoInvestimento(Investimento investimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloFundoInvestimentoLongoPrazoDAO(conn).cadastrarNovoInvestimento(investimento);
	}
	
	public void editarInvestimento(Investimento investimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloFundoInvestimentoLongoPrazoDAO(conn).editarInvestimento(investimento);
	}
	
	public void excluirInvestimento(Investimento investimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloFundoInvestimentoLongoPrazoDAO(conn).excluirInvestimento(investimento);
	}

	public List<Investimento> buscarInvestimentos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new ModuloFundoInvestimentoLongoPrazoDAO(conn).buscarInvestimentos();
		
	}
}
