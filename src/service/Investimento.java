package service;

public class Investimento {

	private int investimento_id;
	private String investimento;
	private double valorMensal;
	private double valorOcasional;
	private double valorTotal;
	
	public Investimento() {
		
	}

	public Investimento(int investimento_id, String investimento, double valorMensal, double valorOcasional,
			double valorTotal) {

		this.investimento_id = investimento_id;
		this.investimento = investimento;
		this.valorMensal = valorMensal;
		this.valorOcasional = valorOcasional;
		this.valorTotal = valorTotal;
	}

	public int getInvestimento_id() {
		return investimento_id;
	}

	public void setInvestimento_id(int investimento_id) {
		this.investimento_id = investimento_id;
	}

	public String getInvestimento() {
		return investimento;
	}

	public void setInvestimento(String investimento) {
		this.investimento = investimento;
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

	@Override
	public String toString() {
		return getInvestimento();
	}
	
	
}
