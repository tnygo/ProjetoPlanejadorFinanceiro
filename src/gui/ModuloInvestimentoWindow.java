package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dao.ModuloFundoInvestimentoLongoPrazoDAO;
import service.Investimento;
import service.ModuloInvestimentoLongoPrazo;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ModuloInvestimentoWindow extends JFrame {

	private JPanel contentPane;
	private JMenu mnNewMenuAjuda;
	private JMenuItem mntmNewMenuItemInicio;
	private JMenuItem mntmNewMenuItemVoltar;
	private JMenuItem mntmNewMenuItemSair;
	private JPanel panel;
	private JLabel lblNewLabelModuloDespesa;
	private JLabel lblCadastrarNovoInvestimento;
	private JLabel lblNewLabelNomeCategoria;
	private JTextField txtNome;
	private JRadioButton rBMensal;
	private JRadioButton rBOcasional;
	private JButton btnNewButtonCadastrar;
	private JSeparator separator;
	private JLabel lblEditarInvestimento;
	private JLabel lblInvestimento;
	private JComboBox cBEditar;
	private JLabel lblNewLabelNomeCategoria_1;
	private JTextField txtEditar;
	private JRadioButton rdbtnNewRadioButtonMensal_1;
	private JRadioButton rdbtnNewRadioButtonOcasional_1;
	private JButton btnEditar;
	private JSeparator separator_1;
	private JLabel lblExcluirInvestimento;
	private JLabel lblInvestimento_1;
	private JComboBox cBExcluir;
	private JButton btnExcluir;
	private JLabel lblValor;
	private JTextField txtValor;

	private ModuloInvestimentoLongoPrazo moduloInvestimento;
	private JLabel lblValor_1;
	private JTextField txtValorEditar;

	private ButtonGroup btnFrequencia1;
	private ButtonGroup btnFrequencia;
	private JMenuBar menuBar;
	private JMenu mnNewSobre;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnAjuda;
	private JMenuItem mntmVoltar;
	private JMenuItem mntmSair;


	public ModuloInvestimentoWindow() throws SQLException, IOException {

		this.initComponents();
		
		moduloInvestimento = new ModuloInvestimentoLongoPrazo();
		
		this.buscarInvestimentos();
		this.limparComponentes();
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
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
		
	
	panel = new JPanel();
		panel.setBounds(35, 65, 677, 182);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Investimento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblCadastrarNovoInvestimento = new JLabel("Novo Investimento");
		lblCadastrarNovoInvestimento.setBounds(46, 22, 118, 13);
		panel.add(lblCadastrarNovoInvestimento);
		
		lblNewLabelNomeCategoria = new JLabel("Nome");
		lblNewLabelNomeCategoria.setBounds(10, 45, 47, 13);
		panel.add(lblNewLabelNomeCategoria);
		
		txtNome = new JTextField();
		txtNome.setText("");
		txtNome.setColumns(10);
		txtNome.setBounds(46, 42, 137, 19);
		panel.add(txtNome);
		
		rBMensal = new JRadioButton("Mensal");
		rBMensal.setBounds(10, 67, 71, 21);
		panel.add(rBMensal);
		
		rBOcasional = new JRadioButton("Ocasional");
		rBOcasional.setBounds(92, 67, 91, 21);
		panel.add(rBOcasional);
		
		btnFrequencia1 = new ButtonGroup();
		btnFrequencia1.add(rBMensal);
		btnFrequencia1.add(rBOcasional);
		
		btnNewButtonCadastrar = new JButton("Cadastrar");
		btnNewButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					btnNewButtonCadastrar();
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!", "Cadastrar Investimento", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonCadastrar.setBounds(10, 121, 177, 21);
		panel.add(btnNewButtonCadastrar);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setBounds(193, 10, 6, 159);
		panel.add(separator);
		
		lblEditarInvestimento = new JLabel("Editar ");
		lblEditarInvestimento.setBounds(300, 22, 109, 13);
		panel.add(lblEditarInvestimento);
		
		lblInvestimento = new JLabel("Investimento");
		lblInvestimento.setBounds(211, 45, 76, 13);
		panel.add(lblInvestimento);
		
		cBEditar = new JComboBox();
		cBEditar.setBounds(297, 41, 124, 21);
		panel.add(cBEditar);
		
		lblNewLabelNomeCategoria_1 = new JLabel("Nome");
		lblNewLabelNomeCategoria_1.setBounds(209, 71, 47, 13);
		panel.add(lblNewLabelNomeCategoria_1);
		
		txtEditar = new JTextField();
		txtEditar.setText("");
		txtEditar.setColumns(10);
		txtEditar.setBounds(284, 68, 137, 19);
		panel.add(txtEditar);
		
		rdbtnNewRadioButtonMensal_1 = new JRadioButton("Mensal");
		rdbtnNewRadioButtonMensal_1.setBounds(219, 94, 78, 21);
		panel.add(rdbtnNewRadioButtonMensal_1);
		
		rdbtnNewRadioButtonOcasional_1 = new JRadioButton("Ocasional");
		rdbtnNewRadioButtonOcasional_1.setBounds(294, 94, 91, 21);
		panel.add(rdbtnNewRadioButtonOcasional_1);
		
		btnFrequencia = new ButtonGroup();
		btnFrequencia.add(rdbtnNewRadioButtonMensal_1);
		btnFrequencia.add(rdbtnNewRadioButtonOcasional_1);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnEditar();
					JOptionPane.showMessageDialog(null, "Investimento editado com sucesso!", "Cadastrar Investimento", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEditar.setBounds(232, 148, 177, 21);
		panel.add(btnEditar);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(446, 10, 2, 159);
		panel.add(separator_1);
		
		lblExcluirInvestimento = new JLabel("Excluir ");
		lblExcluirInvestimento.setBounds(546, 22, 47, 13);
		panel.add(lblExcluirInvestimento);
		
		lblInvestimento_1 = new JLabel("Investimento");
		lblInvestimento_1.setBounds(458, 45, 88, 13);
		panel.add(lblInvestimento_1);
		
		cBExcluir = new JComboBox();
		cBExcluir.setBounds(546, 41, 113, 21);
		panel.add(cBExcluir);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnExcluir();
					JOptionPane.showMessageDialog(null, "Investimento excluído com sucesso!", "Excluir Investimento", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(479, 94, 177, 21);
		panel.add(btnExcluir);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 98, 34, 13);
		panel.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setText("");
		txtValor.setColumns(10);
		txtValor.setBounds(46, 95, 137, 19);
		panel.add(txtValor);
		
		lblValor_1 = new JLabel("Valor");
		lblValor_1.setBounds(222, 125, 34, 13);
		panel.add(lblValor_1);
		
		txtValorEditar = new JTextField();
		txtValorEditar.setText("");
		txtValorEditar.setColumns(10);
		txtValorEditar.setBounds(284, 122, 137, 19);
		panel.add(txtValorEditar);
	
	
	lblNewLabelModuloDespesa = new JLabel("Módulo Investimento a Longo Prazo");
	lblNewLabelModuloDespesa.setBounds(254, 46, 220, 13);
	lblNewLabelModuloDespesa.setFont(new Font("Tahoma", Font.PLAIN, 12));
	contentPane.add(lblNewLabelModuloDespesa);
	
	}

	protected void btnExcluir() throws SQLException, IOException {

		Investimento investimento = new Investimento();
		Investimento i = (Investimento) cBExcluir.getSelectedItem();
		investimento.setInvestimento_id(i.getInvestimento_id());
		
		this.moduloInvestimento.excluirInvestimento(investimento);
		buscarInvestimentos();
		
	}

	protected void btnEditar() throws SQLException, IOException {

		Investimento investimento = new Investimento();
		investimento.setInvestimento(txtEditar.getText());
		Investimento i = (Investimento) cBEditar.getSelectedItem();
		investimento.setInvestimento_id(i.getInvestimento_id());
				
		if(rdbtnNewRadioButtonMensal_1.isSelected()) {
			
			investimento.setValorMensal(Double.parseDouble(txtValorEditar.getText()));
			investimento.setValorTotal((investimento.getValorMensal()*12));
			
		} if(rdbtnNewRadioButtonOcasional_1.isSelected()) {
			
			investimento.setValorOcasional(Double.parseDouble(txtValorEditar.getText()));
			investimento.setValorTotal(investimento.getValorOcasional());
		}
		
		this.moduloInvestimento.editarInvestimento(investimento);
		
		buscarInvestimentos();
		limparComponentes();
	}

	protected void btnNewButtonCadastrar() throws SQLException, IOException {

		Investimento investimento = new Investimento();
		investimento.setInvestimento(txtNome.getText());
		if(rBMensal.isSelected()) {
			
			investimento.setValorMensal(Double.parseDouble(txtValor.getText()));
			investimento.setValorTotal((investimento.getValorMensal()*12));
		} if (rBOcasional.isSelected()) {
			
			investimento.setValorOcasional(Double.parseDouble(txtValor.getText()));
			investimento.setValorTotal(investimento.getValorOcasional());
		}
		
		this.moduloInvestimento.cadastrarNovoInvestimento(investimento);
		
		buscarInvestimentos();
		limparComponentes();
	}

	private void limparComponentes() {

		this.txtNome.setText("");
		this.txtValor.setText("");
		
	}

	private void buscarInvestimentos() throws SQLException, IOException {

	List<Investimento> investimentos = this.moduloInvestimento.buscarInvestimentos();
		
	cBEditar.removeAllItems();
	cBExcluir.removeAllItems();
	
	for (Investimento investimento : investimentos) {
		
		cBEditar.addItem(investimento);
		cBExcluir.addItem(investimento);
		}
	
	}
}

	
