package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.Categoria;
import service.Despesa;
import service.FundoOcasional;

public class ModuloFundoDespesasOcasionaisDAO {

	private Connection conn;

	public ModuloFundoDespesasOcasionaisDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	public void cadastrarNovoFundo(FundoOcasional fundoOcasional) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into fundo_ocasional (fundo_ocasional, mensal, ocasional, total_ano) values (?, ?, ?, ?)");
		
			st.setString(1, fundoOcasional.getFundoOcasional());
			st.setDouble(2, fundoOcasional.getValorMensal());
			st.setDouble(3, fundoOcasional.getValorOcasional());
			st.setDouble(4, fundoOcasional.getValorTotal());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void editarFundo(FundoOcasional fundoOcasional) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update fundo_ocasional set fundo_ocasional = ?, mensal = ?, ocasional = ?, total_ano = ? where fundo_ocasional_id = ?");
			st.setString(1, fundoOcasional.getFundoOcasional());
			st.setDouble(2, fundoOcasional.getValorMensal());
			st.setDouble(3, fundoOcasional.getValorOcasional());
			st.setDouble(4, fundoOcasional.getValorTotal());
			st.setDouble(5, fundoOcasional.getFundoOcasional_id());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void excluirDespesa(FundoOcasional fundoOcasional) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from fundo_ocasional where fundo_ocasional_id = ?");
			st.setInt(1, fundoOcasional.getFundoOcasional_id());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<FundoOcasional> buscarFundos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("Select * from fundo_ocasional order by fundo_ocasional_id");
			
			rs = st.executeQuery();
			
			List<FundoOcasional> listafundoOcasional = new ArrayList<>();
		
		while(rs.next()) {
			
			FundoOcasional fundoOcasional = new FundoOcasional();
			fundoOcasional.setFundoOcasional_id(rs.getInt("fundo_ocasional_id"));
			fundoOcasional.setFundoOcasional(rs.getString("fundo_ocasional"));
			fundoOcasional.setValorMensal(rs.getDouble("mensal"));
			fundoOcasional.setFundoOcasional(rs.getString("ocasional"));
			
			listafundoOcasional.add(fundoOcasional);
		}
		
		return listafundoOcasional;
		
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}
