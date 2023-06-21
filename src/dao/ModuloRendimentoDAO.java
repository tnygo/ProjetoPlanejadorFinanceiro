package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.Categoria;
import service.Despesa;
import service.Rendimento;

public class ModuloRendimentoDAO {

	private Connection conn;
	
	public ModuloRendimentoDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	public void cadastrarNovaCategoria(Categoria categoria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into categoria (categoria) values (?)");
			
			st.setString(1, categoria.getCategoria());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	public void editarCategoria(Categoria categoria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update categoria set categoria = ? where id = ?");
			st.setString(1, categoria.getCategoria());
			st.setInt(2, categoria.getCategoria_id());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public int excluirCategoria(Categoria categoria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from categoria where id = ?");
			st.setInt(1, categoria.getCategoria_id());
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Categoria> buscarCategoria() throws SQLException{
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("Select * from categoria order by id");
			
			rs = st.executeQuery();
			
			List<Categoria> listaCategoria = new ArrayList<>();
			
			while (rs.next()) {
				
				Categoria categoria = new Categoria();
				categoria.setCategoria_id(rs.getInt("id"));
				categoria.setCategoria(rs.getString("categoria"));
				
				listaCategoria.add(categoria);
			}
			
			return listaCategoria;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public void cadastrarRendimento(Rendimento rendimento) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into rendimento (rendimento, categoria_id, mensal, ocasional, total_ano) values (?, ?, ?, ?, ?)");
			
			st.setString(1, rendimento.getRendimento());
			st.setInt(2, rendimento.getCategoria().getCategoria_id());
			st.setDouble(3, rendimento.getValorMensal());
			st.setDouble(4, rendimento.getValorOcasional());
			st.setDouble(5, rendimento.getValorTotal());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	public void editarRendimento(Rendimento rendimento) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update rendimento set rendimento = ?, categoria_id = ?, mensal = ?, ocasional = ?, total_ano = ? where rendimento_id = ?");
			
			st.setString(1, rendimento.getRendimento());
			st.setInt(2, rendimento.getCategoria_id());
			st.setDouble(3, rendimento.getValorMensal());
			st.setDouble(4, rendimento.getValorOcasional());
			st.setDouble(5, rendimento.getValorTotal());
			st.setInt(6, rendimento.getRendimento_id());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void excluirRendimento(Rendimento rendimento) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from rendimento where rendimento_id = ?");
			st.setInt(1, rendimento.getRendimento_id());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<Rendimento> buscarRendimento() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("Select * from rendimento order by rendimento_id");
			
			rs = st.executeQuery();
			
			List<Rendimento> listaRendimento = new ArrayList<>();
			
			while(rs.next()) {
				
				Rendimento rendimento = new Rendimento();
				rendimento.setRendimento_id(rs.getInt("rendimento_id"));
				rendimento.setRendimento(rs.getString("rendimento"));
				rendimento.setValorMensal(rs.getDouble("mensal"));
				rendimento.setValorOcasional(rs.getDouble("ocasional"));
				listaRendimento.add(rendimento);
			}
			return listaRendimento;
		
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
		
	}
}
