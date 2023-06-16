package service;

public class Rendimento {

	private int categoria_id;
	private int rendimento_id;
	private String rendimento;
	private double valorMensal;
	private double valorOcasional;
	private double ValorTotal;
	
	public Rendimento(int categoria_id, int rendimento_id, String rendimento, double valorMensal, double valorOcasional,
			double valorTotal) {

		this.categoria_id = categoria_id;
		this.rendimento_id = rendimento_id;
		this.rendimento = rendimento;
		this.valorMensal = valorMensal;
		this.valorOcasional = valorOcasional;
		this.ValorTotal = valorTotal;
	}

	public Rendimento() {
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}

	public int getRendimento_id() {
		return rendimento_id;
	}

	public void setRendimento_id(int rendimento_id) {
		this.rendimento_id = rendimento_id;
	}

	public String getRendimento() {
		return rendimento;
	}

	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
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
		return ValorTotal;
	}

	public void setValorTotal(double totalAno) {
		ValorTotal = totalAno;
	}
	
	
	
}
