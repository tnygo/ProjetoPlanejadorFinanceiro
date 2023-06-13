package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import service.Categoria;

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
}
