package service;

public class Despesa {

	private int despesa_id;
	private int categoria_id;
	private Categoria categoria;
	private String despesa;
	private double valorMensal;
	private double valorOcasional;
	private double valorTotal;
	
	public Despesa(Categoria categoria, String despesa, double valorMensal, double valorOcasional, double valorTotal) {

		this.categoria = categoria;
		this.despesa = despesa;
		this.valorMensal = valorMensal;
		this.valorOcasional = valorOcasional;
		this.valorTotal = valorTotal;
	}

	public Despesa() {
		
	}

	public int getDespesa_id() {
		return despesa_id;
	}

	public void setDespesa_id(int despesa_id) {
		this.despesa_id = despesa_id;
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDespesa() {
		return despesa;
	}

	public void setDespesa(String despesa) {
		this.despesa = despesa;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public double getValorOcasional() {
		return valorOcasional;
	}

	public void setValorOcasional(double valorOcasional) {
		this.valorOcasional = valorOcasional;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
