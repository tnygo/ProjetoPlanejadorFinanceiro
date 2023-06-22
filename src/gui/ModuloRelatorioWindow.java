package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.Despesa;
import service.FundoOcasional;
import service.Investimento;
import service.ModuloDespesas;
import service.ModuloFundoDespesasOcasionais;
import service.ModuloInvestimentoLongoPrazo;
import service.ModuloRendimento;
import service.Rendimento;

import javax.swing.JButton;

public class ModuloRelatorioWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitulo;

	private ModuloRendimento moduloRendimento;
	private ModuloDespesas moduloDespesas;
	private ModuloInvestimentoLongoPrazo moduloInvestimentoLongoPrazo;
	private ModuloFundoDespesasOcasionais moduloFundoDespesasOcasionais;
	
	public ModuloRelatorioWindow() {
		
		this.initComponents();
		this.moduloRendimento = new ModuloRendimento();
		this.moduloInvestimentoLongoPrazo = new ModuloInvestimentoLongoPrazo();
		this.moduloFundoDespesasOcasionais = new ModuloFundoDespesasOcasionais();
		this.moduloDespesas = new ModuloDespesas();
	}

	private void initComponents(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitulo_1 = new JLabel("UTFinanZ");
		lblTitulo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo_1.setBounds(316, 45, 87, 48);
		contentPane.add(lblTitulo_1);
		
		JButton btnRelatório = new JButton("Gerar Relatório");
		btnRelatório.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					gerarRelatorio();
					JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!", "Modulo Relatório", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRelatório.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRelatório.setBounds(250, 117, 226, 51);
		contentPane.add(btnRelatório);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewSobre = new JMenu("Sobre");
		menuBar.add(mnNewSobre);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Créditos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreditosWindow().setVisible(true);
			}
		});
		mnNewSobre.add(mntmNewMenuItem);
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnAjuda.add(mntmVoltar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnAjuda.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	

		
	}

	protected void gerarRelatorio() throws SQLException {
		
		try {
			
			BufferedWriter documento = new BufferedWriter(new FileWriter("C:\\Users\\anton\\OneDrive\\Documentos\\UTFPR\\6º Semestre\\CC35C - Programação de Aplicativos\\UTFinanZ.xls"));
			
			double valorRendimento = 0.0;
			double valorInvestimento = 0.0;
			double valorDespesas = 0.0;
			double valorDespesasOcasionais = 0.0;
			
			List<Rendimento> listaRendimento = moduloRendimento.buscarRendimento();
			List<Investimento> listaInvestimento = moduloInvestimentoLongoPrazo.buscarInvestimentos();
			List<Despesa> listaDespesas = moduloDespesas.buscarDespesa();
			List<FundoOcasional> listaDespesaOcasional = moduloFundoDespesasOcasionais.buscarFundos();
			
			for (Rendimento rendimento : listaRendimento) {
				
				valorRendimento += rendimento.getValorMensal();
				valorRendimento += rendimento.getValorOcasional();
			}

			for (Investimento investimento : listaInvestimento) {
				
				valorInvestimento += investimento.getValorMensal();
				valorInvestimento += investimento.getValorOcasional();
			}
			
			for (Despesa despesa : listaDespesas) {
				
				valorDespesas += despesa.getValorMensal();
				valorDespesas += despesa.getValorOcasional();
			}

			for (FundoOcasional fundoOcasional : listaDespesaOcasional) {
				
				valorDespesasOcasionais += fundoOcasional.getValorMensal();
				valorDespesasOcasionais += fundoOcasional.getValorOcasional();
			}
			
			documento.write("Total Rendimentos: " + valorRendimento);
			documento.newLine();
			documento.write("Total Investimentos: " + valorInvestimento);
			documento.newLine();
			documento.write("Total Fundo de Despesas: " + valorDespesasOcasionais);
			documento.newLine();
			documento.write("Total Despesas: " + valorDespesas);

			documento.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro " + e.getMessage());
		}
		
	}
}
