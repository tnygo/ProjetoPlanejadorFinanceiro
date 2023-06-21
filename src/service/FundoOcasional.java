package service;

public class FundoOcasional {

	private int fundoOcasional_id;
	private String fundoOcasional;
	private double valorMensal;
	private double valorOcasional;
	private double valorTotal;
	
	public FundoOcasional() {
		
	}

	public FundoOcasional(int fundoOcasional_id, String fundoOcasional, double valorMensal, double valorOcasional,
			double valorTotal) {

		this.fundoOcasional_id = fundoOcasional_id;
		this.fundoOcasional = fundoOcasional;
		this.valorMensal = valorMensal;
		this.valorOcasional = valorOcasional;
		this.valorTotal = valorTotal;
	}

	public int getFundoOcasional_id() {
		return fundoOcasional_id;
	}

	public void setFundoOcasional_id(int fundoOcasional_id) {
		this.fundoOcasional_id = fundoOcasional_id;
	}

	public String getFundoOcasional() {
		return fundoOcasional;
	}

	public void setFundoOcasional(String fundoOcasional) {
		this.fundoOcasional = fundoOcasional;
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
		return getFundoOcasional();
	}
	
	
}
