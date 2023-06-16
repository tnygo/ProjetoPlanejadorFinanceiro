package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public void cadastrarNovaRendimento(Rendimento rendimento) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into rendimento (rendimento, categoria_id, mensal, ocasional, total_ano) values (?, ?, ?, ?, ?)");
			
			st.setString(1, rendimento.getRendimento());
			st.setInt(2, rendimento.getCategoria_id());
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
			
			st = conn.prepareStatement("update rendimento set rendimento = ?, categoria_id = ?, mensal = ?, ocasional = ?, total_ano = ? where despesa_id = ?");
			
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
}
