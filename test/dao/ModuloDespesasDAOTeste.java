package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import service.Categoria;

public class ModuloDespesasDAOTeste {

	public static void cadastrarNovaCategoria() throws SQLException, IOException{
		
		Categoria categoria = new Categoria();
		categoria.setCategoria("Venda");
		
		Connection conn = BancoDados.conectar();
		new ModuloDespesasDAO(conn).cadastrarNovaCategoria(categoria);
		
		System.out.println("Categoria cadastrada com sucesso.");
	}
	
	public static void main(String[] args) {
		
		try {
			
			ModuloDespesasDAOTeste.cadastrarNovaCategoria();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
