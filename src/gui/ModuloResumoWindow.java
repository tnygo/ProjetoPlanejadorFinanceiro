package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import service.Despesa;
import service.FundoOcasional;
import service.Investimento;
import service.ModuloDespesas;
import service.ModuloFundoDespesasOcasionais;
import service.ModuloInvestimentoLongoPrazo;
import service.ModuloRendimento;
import service.Rendimento;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ModuloResumoWindow extends JFrame {

	private JPanel contentPane;
	private JMenu mnNewMenuAjuda;
	private JMenuItem mntmNewMenuItemInicio;
	private JMenuItem mntmNewMenuItemVoltar;
	private JMenuItem mntmNewMenuItemSair;
	private JPanel panel;
	private JLabel lblNewLabelModuloDespesa;
	private JPanel panel_1;
	private JLabel lblMensal;
	private JComboBox comboBoxMes;
	private JLabel lblSelecioneOAno;
	private JComboBox comboBox_1;
	private JTable tableMensal;
	private JTable tableaAnual;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private JMenu mnNewMenuSobre;
	
	private ModuloRendimento moduloRendimento;
	private ModuloDespesas moduloDespesas;
	private ModuloInvestimentoLongoPrazo moduloInvestimentoLongoPrazo;
	private ModuloFundoDespesasOcasionais moduloFundoDespesasOcasionais;
	
	public ModuloResumoWindow() {

		this.initComponents();
		this.moduloRendimento = new ModuloRendimento();
		this.moduloInvestimentoLongoPrazo = new ModuloInvestimentoLongoPrazo();
		this.moduloFundoDespesasOcasionais = new ModuloFundoDespesasOcasionais();
		this.moduloDespesas = new ModuloDespesas();
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);

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
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(35, 52, 677, 147);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resumo Mensal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 20, 638, 113);
		panel.add(scrollPane_1);
		
		tableMensal = new JTable();
		scrollPane_1.setViewportView(tableMensal);
		tableMensal.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rendimento", null},
				{"Investimento a Longo Prazo", null},
				{"Fundo para Despesas Ocasionais", null},
				{"Valor Total Disponível por Mês para Despesas", null},
				{"Valor Total das Despesas Orçadas para o Mês", null},
				{"Valor Total", null},
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Total Mensal"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableMensal.getColumnModel().getColumn(0).setPreferredWidth(496);
		tableMensal.getColumnModel().getColumn(1).setPreferredWidth(555);
		
		lblNewLabelModuloDespesa = new JLabel("Módulo Resumo");
		lblNewLabelModuloDespesa.setBounds(315, 10, 111, 13);
		lblNewLabelModuloDespesa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabelModuloDespesa);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resumo Anual", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(35, 240, 677, 168);
		contentPane.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 638, 136);
		panel_1.add(scrollPane);
		
		tableaAnual = new JTable();
		scrollPane.setViewportView(tableaAnual);
		tableaAnual.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rendimento", null, null, null},
				{"Investimento a Longo Prazo", null, null, null},
				{"Fundo para despesas Ocasionais", null, null, null},
				{"Total Dispon\u00EDvel para Despesas Durante o Ano", null, null, null},
				{"Total Despesas Mensais Or\u00E7adas (12 anos)", null, null, null},
				{"Total Despesas Ocasionais para o Ano", null, null, null},
				{"Valor Total", null, null, null},
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Mensal (x12)", "Ocasional", "Total Anual"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableaAnual.getColumnModel().getColumn(0).setPreferredWidth(281);
		tableaAnual.getColumnModel().getColumn(1).setPreferredWidth(128);
		tableaAnual.getColumnModel().getColumn(2).setPreferredWidth(114);
		tableaAnual.getColumnModel().getColumn(3).setPreferredWidth(110);
		
		lblMensal = new JLabel("Selecione o mês");
		lblMensal.setBounds(45, 33, 98, 13);
		contentPane.add(lblMensal);
		String[] mes = {"1 - Janeiro", "2 - Fevereiro", "3 - Março", "4 - Abril", "5 - Maio", "6 - Junho", "7 - Julho", "8 - Agosto", "9 - Setembro", "10 - Outubro", "11 - Novembro", "12 - Dezembro"};
		
		comboBoxMes = new JComboBox(mes);
		comboBoxMes.setBounds(157, 29, 109, 21);
		contentPane.add(comboBoxMes);
		
		
		lblSelecioneOAno = new JLabel("Selecione o ano");
		lblSelecioneOAno.setBounds(45, 209, 98, 13);
		contentPane.add(lblSelecioneOAno);
		
		String[] ano = {"2023"};
		comboBox_1 = new JComboBox(ano);
		comboBox_1.setBounds(157, 209, 109, 21);
		contentPane.add(comboBox_1);
		
		JButton btnMensalConfirma = new JButton("Procurar");
		btnMensalConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarResumoMes();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMensalConfirma.setBounds(276, 29, 85, 21);
		contentPane.add(btnMensalConfirma);
		
		JButton btnAnualConfirma = new JButton("Procurar");
		btnAnualConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarResumoAno();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAnualConfirma.setBounds(276, 209, 85, 21);
		contentPane.add(btnAnualConfirma);
	}

	protected void buscarResumoAno() throws SQLException, IOException {
		
		DefaultTableModel modeloAno = (DefaultTableModel) tableaAnual.getModel();
		
		double valorRendimentoMensal = 0.0;
		double valorRendimentoOcasional = 0.0;
		double valorInvestimentoMensal = 0.0;
		double valorInvestimentoOcasional = 0.0;
		double valorDespesasOcasionais = 0.0;
		double valorDespesasMensais = 0.0;
		double valorDespesasocasionais = 0.0;
		
		
		List<Rendimento> listaRendimento = moduloRendimento.buscarRendimento();
		List<Investimento> listaInvestimento = moduloInvestimentoLongoPrazo.buscarInvestimentos();
		List<FundoOcasional> listaDespesaOcasional = moduloFundoDespesasOcasionais.buscarFundos();
		List<Despesa> listaDespesas = moduloDespesas.buscarDespesa();
		
		for (Rendimento rendimento : listaRendimento) {
			
			valorRendimentoMensal += rendimento.getValorMensal();
			valorRendimentoOcasional += rendimento.getValorOcasional();
		}
		
		for (Investimento investimento : listaInvestimento) {
			
			valorInvestimentoMensal += investimento.getValorMensal();
			valorInvestimentoOcasional += investimento.getValorOcasional();
		}
		
		for (FundoOcasional fundoOcasional : listaDespesaOcasional) {
			
			valorDespesasOcasionais += fundoOcasional.getValorMensal();
			valorDespesasOcasionais += fundoOcasional.getValorOcasional();
		}
		
		for (Despesa despesa : listaDespesas) {
			
			valorDespesasMensais += despesa.getValorMensal();
			valorDespesasocasionais += despesa.getValorOcasional();
		}
		
		double totalDespesas = (valorRendimentoMensal*12)+ valorRendimentoOcasional - (valorInvestimentoMensal*12)+valorInvestimentoOcasional;
		double totalRestante = totalDespesas - valorDespesasMensais - valorDespesasocasionais;		
		
		modeloAno.setValueAt(valorRendimentoMensal*12, 0, 1);
		modeloAno.setValueAt(valorRendimentoOcasional, 0, 2);
		modeloAno.setValueAt((valorRendimentoMensal*12)+valorRendimentoOcasional, 0, 3);
		
		modeloAno.setValueAt(valorInvestimentoMensal*12, 1, 1);
		modeloAno.setValueAt(valorInvestimentoOcasional, 1, 2);
		modeloAno.setValueAt((valorInvestimentoMensal*12)+valorInvestimentoOcasional, 1, 3);
		
		modeloAno.setValueAt(valorDespesasOcasionais, 2, 1);
		modeloAno.setValueAt(valorDespesasOcasionais, 2, 3);
		
		modeloAno.setValueAt(totalDespesas, 3, 3);
		
		modeloAno.setValueAt(valorDespesasMensais, 4, 3);
		modeloAno.setValueAt(valorDespesasocasionais, 5, 3);
		modeloAno.setValueAt(totalRestante, 6, 3);
		
	}

	protected void buscarResumoMes() throws SQLException, IOException {

		DefaultTableModel modeloMes = (DefaultTableModel) tableMensal.getModel();
		modeloMes.fireTableDataChanged();
		
		double valorRendimento = 0.0;
		double valorInvestimento = 0.0;
		double valorDespesasOcasionais = 0.0;
		double valorDespesas = 0.0;
		double valorDisponivelDespesas = 0.0;
		double valorTotal = 0.0;
		
		List<Rendimento> listaRendimento = moduloRendimento.buscarRendimento();
		List<Investimento> listaInvestimento = moduloInvestimentoLongoPrazo.buscarInvestimentos();	
		List<FundoOcasional> listaDespesaOcasional = moduloFundoDespesasOcasionais.buscarFundos();
		List<Despesa> listaDespesas = moduloDespesas.buscarDespesa();
		
		for (Rendimento rendimento : listaRendimento) {
			
			valorRendimento += rendimento.getValorMensal();
			valorRendimento += rendimento.getValorOcasional();
		}
		
		for (Investimento investimento : listaInvestimento) {
			
			valorInvestimento += investimento.getValorMensal();
			valorInvestimento += investimento.getValorOcasional();
		}
		
		for (FundoOcasional fundoOcasional : listaDespesaOcasional) {
			
			valorDespesasOcasionais += fundoOcasional.getValorMensal();
			valorDespesasOcasionais += fundoOcasional.getValorOcasional();
		}

		for (Despesa despesa : listaDespesas) {
			
			valorDespesas += despesa.getValorMensal();
			valorDespesas += despesa.getValorOcasional();
		}
		
		valorDisponivelDespesas += (valorRendimento - valorInvestimento - valorDespesasOcasionais);
		valorTotal += (valorDisponivelDespesas - valorDespesas);
		
		modeloMes.setValueAt(valorRendimento, 0, 1);
		modeloMes.setValueAt(valorInvestimento, 1, 1);
		modeloMes.setValueAt(valorDespesasOcasionais, 2, 1);
		modeloMes.setValueAt(valorDisponivelDespesas, 3, 1);
		modeloMes.setValueAt(valorDespesas, 4, 1);
		modeloMes.setValueAt(valorTotal, 5, 1);
	}	
	
}
