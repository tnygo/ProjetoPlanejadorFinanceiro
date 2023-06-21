package service;

public class Categoria {

	private int categoria_id;
	private String categoria;
	
	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	public Categoria() {
		
	}

	public Categoria(String categoria) {

		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	@Override
	public String toString() {
		return this.getCategoria();
	}
	
	
	
}
