package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ModuloFundoDespesasOcasionaisDAO;

public class ModuloFundoDespesasOcasionais {

	public void cadastrarNovoFundo(FundoOcasional fundoOcasional) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloFundoDespesasOcasionaisDAO(conn).cadastrarNovoFundo(fundoOcasional);
	}
	
	public void editarFundo(FundoOcasional fundoOcasional) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloFundoDespesasOcasionaisDAO(conn).editarFundo(fundoOcasional);
	}
	
	public void excluirFundo(FundoOcasional fundoOcasional) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ModuloFundoDespesasOcasionaisDAO(conn).excluirDespesa(fundoOcasional);
	}

	public List<FundoOcasional> buscarFundos() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new ModuloFundoDespesasOcasionaisDAO(conn).buscarFundos();
	}
}
