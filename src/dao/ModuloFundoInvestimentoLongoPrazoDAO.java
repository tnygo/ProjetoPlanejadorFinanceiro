package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.FundoOcasional;
import service.Investimento;

public class ModuloFundoInvestimentoLongoPrazoDAO {

	private Connection conn;

	public ModuloFundoInvestimentoLongoPrazoDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	public void cadastrarNovoInvestimento(Investimento investimento) throws SQLException{
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into investimento (investimento, mensal, ocasional, total_ano) values (?, ?, ?, ?)");
			st.setString(1, investimento.getInvestimento());
			st.setDouble(2, investimento.getValorMensal());
			st.setDouble(3, investimento.getValorOcasional());
			st.setDouble(4, investimento.getValorTotal());
			
			st.executeUpdate();
			
		} finally{
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void editarInvestimento(Investimento investimento) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update investimento set investimento = ?, mensal = ?, ocasional = ?, total_ano = ? where investimento_id = ?");
			st.setString(1, investimento.getInvestimento());
			st.setDouble(2, investimento.getValorMensal());
			st.setDouble(3, investimento.getValorOcasional());
			st.setDouble(4, investimento.getValorTotal());
			st.setDouble(5, investimento.getInvestimento_id());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void excluirInvestimento(Investimento investimento) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from investimento where investimento_id = ?");
			st.setInt(1, investimento.getInvestimento_id());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<Investimento> buscarInvestimentos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("Select * from investimento order by investimento_id");
			
			rs = st.executeQuery();
			
			List<Investimento> listaInvestimento = new ArrayList<>();
			
			while(rs.next()) {
				
				Investimento investimento = new Investimento();
				investimento.setInvestimento_id(rs.getInt("investimento_id"));
				investimento.setInvestimento(rs.getString("investimento"));
				investimento.setValorMensal(rs.getDouble("mensal"));
				investimento.setValorOcasional(rs.getDouble("ocasional"));
				listaInvestimento.add(investimento);
				
			}
			
			return listaInvestimento;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}
