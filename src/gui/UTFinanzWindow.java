package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class UTFinanzWindow extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewSobre;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnAjuda;
	private JMenuItem mntmVoltar;
	private JMenuItem mntmSair;
	private JLabel lblTitulo;
	private JButton btnRendimento;
	private JButton btnDespesas;
	private JButton btnInvestimento;
	private JButton btnDespesasOcasionais;
	private JButton btnRelatorio;
	private JButton btnResumo;

	public UTFinanzWindow() {

		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewSobre = new JMenu("Sobre");
		menuBar.add(mnNewSobre);
		
		mntmNewMenuItem = new JMenuItem("Créditos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreditosWindow().setVisible(true);
			}
		});
		mnNewSobre.add(mntmNewMenuItem);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmVoltar = new JMenuItem("Voltar");
		mnAjuda.add(mntmVoltar);
		
		mntmSair = new JMenuItem("Sair");
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
		
		lblTitulo = new JLabel("UTFinanZ");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(316, 45, 87, 48);
		contentPane.add(lblTitulo);
		
		btnRendimento = new JButton("Módulo Rendimento");
		btnRendimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ModuloRendimentoWindow().setVisible(true);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRendimento.setBounds(118, 121, 226, 51);
		contentPane.add(btnRendimento);
		
		btnDespesas = new JButton("Módulo Despesas");
		btnDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ModuloDespesaWindow().setVisible(true);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDespesas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDespesas.setBounds(375, 121, 226, 51);
		contentPane.add(btnDespesas);
		
		btnInvestimento = new JButton("Módulo Investimento");
		btnInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ModuloInvestimentoWindow().setVisible(true);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInvestimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInvestimento.setBounds(121, 195, 226, 51);
		contentPane.add(btnInvestimento);
		
		btnDespesasOcasionais = new JButton("Módulo Despesas Ocasionais");
		btnDespesasOcasionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ModuloDespesasOcasionaisWindow().setVisible(true);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDespesasOcasionais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDespesasOcasionais.setBounds(375, 195, 226, 51);
		contentPane.add(btnDespesasOcasionais);
		
		btnRelatorio = new JButton("Módulo Relatório");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ModuloRelatorioWindow().setVisible(true);
			}
		});
		btnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRelatorio.setBounds(375, 270, 226, 51);
		contentPane.add(btnRelatorio);
		
		btnResumo = new JButton("Módulo Resumo");
		btnResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ModuloResumoWindow().setVisible(true);
			}
		});
		btnResumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResumo.setBounds(118, 270, 226, 51);
		contentPane.add(btnResumo);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UTFinanzWindow frame = new UTFinanzWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
