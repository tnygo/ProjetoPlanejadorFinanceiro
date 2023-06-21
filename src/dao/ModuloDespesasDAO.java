package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.Categoria;
import service.Despesa;

public class ModuloDespesasDAO {
	
	private Connection conn;

	public ModuloDespesasDAO(Connection conn) {
		
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
	
	public void cadastrarNovaDespesa(Despesa despesa) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into despesas (despesa, categoria_id, mensal, ocasional, total_ano) values (?, ?, ?, ?, ?)");
			
			st.setString(1, despesa.getDespesa());
			st.setInt(2, despesa.getCategoria().getCategoria_id());
			st.setDouble(3, despesa.getValorMensal());
			st.setDouble(4, despesa.getValorOcasional());
			st.setDouble(5, despesa.getValorTotal());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void editarDespesa(Despesa despesa) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update despesas set despesa = ?, categoria_id = ?, mensal = ?, ocasional = ?, total_ano = ? where despesa_id = ?");
			
			st.setString(1, despesa.getDespesa());
			st.setInt(2, despesa.getCategoria_id());
			st.setDouble(3, despesa.getValorMensal());
			st.setDouble(4, despesa.getValorOcasional());
			st.setDouble(5, despesa.getValorTotal());
			st.setInt(6, despesa.getDespesa_id());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void excluirDespesa(Despesa despesa) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from despesas where despesa_id = ?");
			st.setInt(1, despesa.getDespesa_id());
			
			st.executeUpdate();
			
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
	public List<Despesa> buscarDespesa() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("Select * from despesas order by despesa_id");
			
			rs = st.executeQuery();
			
			List<Despesa> listaDespesa = new ArrayList<>();
			
			while(rs.next()) {
				
				Despesa despesa = new Despesa();
				despesa.setDespesa_id(rs.getInt("despesa_id"));
				despesa.setDespesa(rs.getString("despesa"));
				despesa.setValorMensal(rs.getDouble("mensal"));
				despesa.setValorOcasional(rs.getDouble("ocasional"));
				
				listaDespesa.add(despesa);
				
			}
			
			return listaDespesa;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
}
