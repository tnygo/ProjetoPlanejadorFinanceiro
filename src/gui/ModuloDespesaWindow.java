package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dao.ModuloDespesasDAO;
import service.Categoria;
import service.Despesa;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import service.ModuloDespesas;
import dao.ModuloDespesasDAO;
import javax.swing.JFormattedTextField;

public class ModuloDespesaWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField_1NovoNome;
	private JTextField txtCadasCate;
	private JTextField textField_3Nome;
	private JComboBox comboBoxEditarCategoria;
	private JMenu mnNewMenuAjuda;
	private JMenuItem mntmNewMenuItemInicio;
	private JMenuItem mntmNewMenuItemVoltar;
	private JMenuItem mntmNewMenuItemSair;
	private JPanel panel;
	private JButton btnNewButtonCadastrarCategoria;
	private JLabel lblNewLabelSelecione;
	private JLabel lblNewLabel_1;
	private JButton btnNewButtonEditarCategoria;
	private JButton btnNewButtonExcluirCategoria; 
	private JLabel lblNewLabelNomeCategoria;
	private JLabel lblNewLabel;
	private JLabel lblNewLabelEditarCategoria;
	private JSeparator separator;
	private JLabel lblNewLabel_2SelecioarCategoria;
	private JLabel lblNewLabelExcluirCategoria;
	private JSeparator separator_1;
	private JComboBox comboBox;
	private JMenu mnNewMenuSobre;
	private JLabel lblNewLabelModuloDespesa;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabelCategoria;
	private JComboBox cBCategoria;
	private JLabel lblNewLabel_3;
	private JRadioButton rdbtnNewRadioButtonMensal;
	private JRadioButton rdbtnNewRadioButtonOcasional;
	private ButtonGroup btnFrequencia;
	private JButton btnNewButtonCadastrar;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JLabel lblNewLabelEditarDespesa;
	private JLabel lblNewLabel_4SelecDespesa;
	private JComboBox comboBox_2SeleDesp;
	private JLabel lblNewLabel_4Categoria;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox_3SelecCat;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private ButtonGroup btnGroupFrequenciaEditar;
	private JButton btnNewButtonEditar;
	private JLabel lblNewLabel_6ExcluirDes;
	private JLabel lblNewLabel_6SelDes;
	private JComboBox comboBox_2;
	private JButton btnNewButtonExcluir;
	
	private ModuloDespesas moduloDespesas;
	private JLabel lblNewLabel_6;
	private JFormattedTextField txtValorDespesa;
	private JLabel lblNewLabel_5Valor;
	private JFormattedTextField formattedTextField;
	private JMenuBar menuBar;
	private JMenu mnNewSobre;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmVoltar;
	private JMenu mnAjuda;
	private JMenuItem mntmSair;
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public ModuloDespesaWindow() throws SQLException, IOException {
		
		this.initComponents();
		
		this.moduloDespesas = new ModuloDespesas();
		
		this.buscarCategorias();
		this.buscarDespesas();
		this.limparComponentes();
		
	}

	public void initComponents() {
		
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
		panel.setBounds(35, 33, 677, 125);
		panel.setBorder(new TitledBorder(null, "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButtonCadastrarCategoria = new JButton("Cadastrar");
		btnNewButtonCadastrarCategoria.setBounds(21, 94, 177, 21);
		panel.add(btnNewButtonCadastrarCategoria);
		btnNewButtonCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					try {
						btnNewButtonCadastrarCategoria();
						JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!", "Cadastrar Categoria", JOptionPane.INFORMATION_MESSAGE);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
		btnNewButtonEditarCategoria = new JButton("Editar");
		btnNewButtonEditarCategoria.setBounds(249, 94, 177, 21);
		panel.add(btnNewButtonEditarCategoria);
		try {
			btnNewButtonEditarCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						btnNewButtonEditarCategoria();
						JOptionPane.showMessageDialog(null, "Categoria editada com sucesso!", "Editar Categoria", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		btnNewButtonExcluirCategoria = new JButton("Excluir");
		btnNewButtonExcluirCategoria.setBounds(477, 94, 177, 21);
		panel.add(btnNewButtonExcluirCategoria);
		btnNewButtonExcluirCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButtonExcluirCategoria();
					JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!", "Excluir Categoria", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		lblNewLabelNomeCategoria = new JLabel("Nome");
		lblNewLabelNomeCategoria.setBounds(21, 57, 47, 13);
		panel.add(lblNewLabelNomeCategoria);
		
		txtNome = new JTextField();
		txtNome.setBounds(61, 54, 137, 19);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		lblNewLabel = new JLabel("Cadastrar Nova Categoria");
		lblNewLabel.setBounds(29, 21, 153, 13);
		panel.add(lblNewLabel);
		
		lblNewLabelEditarCategoria = new JLabel("Editar Categoria");
		lblNewLabelEditarCategoria.setBounds(281, 21, 94, 13);
		panel.add(lblNewLabelEditarCategoria);
		
		separator = new JSeparator();
		separator.setBounds(207, 10, 2, 105);
		panel.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 0, 0));
		
		lblNewLabelSelecione = new JLabel("Categoria");
		lblNewLabelSelecione.setBounds(216, 44, 146, 13);
		panel.add(lblNewLabelSelecione);
		
		comboBoxEditarCategoria = new JComboBox();
		comboBoxEditarCategoria.setBounds(297, 40, 140, 21);
		panel.add(comboBoxEditarCategoria);
		
		lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(219, 71, 73, 13);
		panel.add(lblNewLabel_1);
		
		textField_1NovoNome = new JTextField();
		textField_1NovoNome.setBounds(297, 68, 140, 19);
		panel.add(textField_1NovoNome);
		textField_1NovoNome.setColumns(10);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(447, 10, 12, 105);
		panel.add(separator_1);
		
		lblNewLabelExcluirCategoria = new JLabel("Excluir Categoria");
		lblNewLabelExcluirCategoria.setBounds(514, 21, 104, 13);
		panel.add(lblNewLabelExcluirCategoria);
		
		lblNewLabel_2SelecioarCategoria = new JLabel("Categoria");
		lblNewLabel_2SelecioarCategoria.setBounds(455, 57, 132, 13);
		panel.add(lblNewLabel_2SelecioarCategoria);
		
		comboBox = new JComboBox();
		comboBox.setBounds(540, 53, 127, 21);
		panel.add(comboBox);
		
		lblNewLabelModuloDespesa = new JLabel("Módulo Despesa");
		lblNewLabelModuloDespesa.setBounds(323, 10, 95, 13);
		lblNewLabelModuloDespesa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabelModuloDespesa);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Despesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(35, 168, 677, 208);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Nova Despesa");
		lblNewLabel_2.setBounds(61, 20, 102, 13);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabelCategoria = new JLabel("Categoria");
		lblNewLabelCategoria.setBounds(10, 43, 80, 13);
		panel_1.add(lblNewLabelCategoria);
		
		cBCategoria = new JComboBox();
		cBCategoria.setBounds(87, 39, 113, 21);
		panel_1.add(cBCategoria);
		
		lblNewLabel_3 = new JLabel("Nome");
		lblNewLabel_3.setBounds(10, 69, 45, 13);
		panel_1.add(lblNewLabel_3);
		
		txtCadasCate = new JTextField();
		txtCadasCate.setBounds(87, 66, 113, 19);
		panel_1.add(txtCadasCate);
		txtCadasCate.setColumns(10);
		
		rdbtnNewRadioButtonMensal = new JRadioButton("Mensal");
		rdbtnNewRadioButtonMensal.setBounds(20, 95, 87, 21);
		panel_1.add(rdbtnNewRadioButtonMensal);
		
		rdbtnNewRadioButtonOcasional = new JRadioButton("Ocasional");
		rdbtnNewRadioButtonOcasional.setBounds(109, 95, 91, 21);
		panel_1.add(rdbtnNewRadioButtonOcasional);
		
		btnFrequencia = new ButtonGroup();
		btnFrequencia.add(rdbtnNewRadioButtonMensal);
		btnFrequencia.add(rdbtnNewRadioButtonOcasional);
		
		btnNewButtonCadastrar = new JButton("Cadastrar");
		btnNewButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButtonCadastrar();
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!", "Cadastrar Despesa", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButtonCadastrar.setBounds(20, 148, 164, 21);
		panel_1.add(btnNewButtonCadastrar);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(217, 138, 21, -116);
		panel_1.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(210, 11, 21, 187);
		panel_1.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(457, 10, 2, 188);
		panel_1.add(separator_4);
		
		lblNewLabelEditarDespesa = new JLabel("Editar Despesa");
		lblNewLabelEditarDespesa.setBounds(283, 20, 91, 13);
		panel_1.add(lblNewLabelEditarDespesa);
		
		lblNewLabel_4SelecDespesa = new JLabel("Despesa");
		lblNewLabel_4SelecDespesa.setBounds(217, 43, 100, 13);
		panel_1.add(lblNewLabel_4SelecDespesa);
		
		comboBox_2SeleDesp = new JComboBox();
		comboBox_2SeleDesp.setBounds(312, 39, 135, 21);
		panel_1.add(comboBox_2SeleDesp);
		
		lblNewLabel_4Categoria = new JLabel("Categoria");
		lblNewLabel_4Categoria.setBounds(217, 69, 60, 13);
		panel_1.add(lblNewLabel_4Categoria);
		
		lblNewLabel_4 = new JLabel("Nome");
		lblNewLabel_4.setBounds(217, 99, 45, 13);
		panel_1.add(lblNewLabel_4);
		
		comboBox_3SelecCat = new JComboBox();
		comboBox_3SelecCat.setBounds(312, 65, 135, 21);
		panel_1.add(comboBox_3SelecCat);
		
		textField_3Nome = new JTextField();
		textField_3Nome.setBounds(313, 96, 134, 19);
		panel_1.add(textField_3Nome);
		textField_3Nome.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Mensal");
		rdbtnNewRadioButton.setBounds(227, 122, 90, 21);
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Ocasional");
		rdbtnNewRadioButton_1.setBounds(344, 122, 103, 21);
		panel_1.add(rdbtnNewRadioButton_1);
		
		btnGroupFrequenciaEditar = new ButtonGroup();
		btnGroupFrequenciaEditar.add(rdbtnNewRadioButton);
		btnGroupFrequenciaEditar.add(rdbtnNewRadioButton_1);
		
		btnNewButtonEditar = new JButton("Editar");
		btnNewButtonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButtonEditar();
					JOptionPane.showMessageDialog(null, "Despesa editada com sucesso!", "Editar Despesa", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonEditar.setBounds(259, 177, 156, 21);
		panel_1.add(btnNewButtonEditar);
		
		lblNewLabel_6ExcluirDes = new JLabel("Excluir Despesa");
		lblNewLabel_6ExcluirDes.setBounds(514, 20, 102, 13);
		panel_1.add(lblNewLabel_6ExcluirDes);
		
		lblNewLabel_6SelDes = new JLabel("Despesa");
		lblNewLabel_6SelDes.setBounds(469, 69, 94, 13);
		panel_1.add(lblNewLabel_6SelDes);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(554, 65, 113, 21);
		panel_1.add(comboBox_2);
		
		btnNewButtonExcluir = new JButton("Excluir");
		btnNewButtonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButtonExcluir();
					JOptionPane.showMessageDialog(null, "Despesa excluída com sucesso!", "Excluir Despesa", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonExcluir.setBounds(488, 122, 164, 21);
		panel_1.add(btnNewButtonExcluir);
		
		lblNewLabel_6 = new JLabel("Valor");
		lblNewLabel_6.setBounds(10, 125, 45, 13);
		panel_1.add(lblNewLabel_6);
		
		txtValorDespesa = new JFormattedTextField();
		txtValorDespesa.setBounds(46, 122, 138, 19);
		panel_1.add(txtValorDespesa);
		
		lblNewLabel_5Valor = new JLabel("Valor");
		lblNewLabel_5Valor.setBounds(232, 152, 45, 13);
		panel_1.add(lblNewLabel_5Valor);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(312, 149, 135, 19);
		panel_1.add(formattedTextField);
	}

	protected void btnNewButtonExcluir() throws SQLException, IOException {

		Despesa despesa = new Despesa();
		Despesa d = (Despesa) comboBox_2.getSelectedItem();
		despesa.setDespesa_id(d.getDespesa_id());
		this.moduloDespesas.excluirDespesa(despesa);
		buscarDespesas();
	}

	protected void btnNewButtonEditar() throws SQLException, IOException {

		Despesa despesa = new Despesa();
		Despesa d = (Despesa) comboBox_2SeleDesp.getSelectedItem();
		Categoria categoria = (Categoria) comboBox_3SelecCat.getSelectedItem();
		despesa.setCategoria(categoria);
		despesa.setCategoria_id(categoria.getCategoria_id());
		despesa.setDespesa(textField_3Nome.getText());
		despesa.setDespesa_id(d.getDespesa_id());
		
		if(rdbtnNewRadioButton.isSelected()) {
			
			despesa.setValorMensal(Double.parseDouble(formattedTextField.getText()));
			despesa.setValorTotal((despesa.getValorMensal()*12));
		} if (rdbtnNewRadioButton_1.isSelected()) {
			
			despesa.setValorOcasional(Double.parseDouble(formattedTextField.getText()));
			despesa.setValorTotal(despesa.getValorOcasional());
		}
		
		this.moduloDespesas.editarDespesa(despesa);
		
		buscarDespesas();
		limparComponentes();
	}

	protected void btnNewButtonCadastrar() throws SQLException, IOException {

		Despesa despesa = new Despesa();
		Categoria categoria = (Categoria) cBCategoria.getSelectedItem();
		despesa.setCategoria(categoria);
		despesa.setCategoria_id(categoria.getCategoria_id());
		despesa.setDespesa(txtCadasCate.getText());
		
		if(rdbtnNewRadioButtonMensal.isSelected()) {
			
			despesa.setValorMensal(Double.parseDouble(txtValorDespesa.getText()));
			despesa.setValorTotal((despesa.getValorMensal()*12));
			
		} if (rdbtnNewRadioButtonOcasional.isSelected()) {
			
			despesa.setValorOcasional(Double.parseDouble(txtValorDespesa.getText()));
			despesa.setValorTotal(despesa.getValorOcasional());
		}
		
		this.moduloDespesas.cadastrarNovaDespesa(despesa);
		buscarDespesas();
		limparComponentes();
	}

	public void buscarCategorias() throws SQLException, IOException {
		
		List<Categoria> categorias = this.moduloDespesas.buscarCategoria();
		
		comboBox.removeAllItems();
		comboBoxEditarCategoria.removeAllItems();
		cBCategoria.removeAllItems();
		comboBox_3SelecCat.removeAllItems();
		for (Categoria categoria : categorias) {
			
			comboBoxEditarCategoria.addItem(categoria);
			comboBox.addItem(categoria);
			cBCategoria.addItem(categoria);
			comboBox_3SelecCat.addItem(categoria);
		}
		
		
	}
	
	public void buscarDespesas() throws SQLException, IOException {
		
		List<Despesa> despesas = this.moduloDespesas.buscarDespesa();
		
		comboBox_2SeleDesp.removeAllItems();
		comboBox_2.removeAllItems();
		for (Despesa despesa : despesas) {
			
			comboBox_2SeleDesp.addItem(despesa);
			comboBox_2.addItem(despesa);
		}
		
	}
	private void limparComponentes() {
		this.txtNome.setText("");
		this.textField_1NovoNome.setText("");
		this.txtCadasCate.setText("");
		this.textField_3Nome.setText("");
	}
	
	protected void btnNewButtonExcluirCategoria() throws SQLException, IOException {
		Categoria categoria = new Categoria();
		Categoria c = (Categoria) comboBox.getSelectedItem();
		categoria.setCategoria_id(c.getCategoria_id());
		this.moduloDespesas.excluirCategoria(categoria);
		comboBox.removeAllItems();
		buscarCategorias();
		
	}

	protected void btnNewButtonEditarCategoria() throws SQLException, IOException {

		Categoria categoria = new Categoria();
		categoria.setCategoria(this.textField_1NovoNome.getText());
		Categoria c = (Categoria) comboBoxEditarCategoria.getSelectedItem();
		categoria.setCategoria_id(c.getCategoria_id());
		this.moduloDespesas.editarCategoria(categoria);
		buscarCategorias();
		limparComponentes();
	}

	protected void btnNewButtonCadastrarCategoria() throws SQLException, IOException {
		
		Categoria categoria = new Categoria(); //CRIANDO OBJETO CATEGORIA 
		categoria.setCategoria(this.txtNome.getText()); //COLETANDO INFORMAÇÕES DO CAMPO TEXTO
		this.moduloDespesas.cadastrarNovaCategoria(categoria); //ENVIANDO O OBJETO AO PACOTE SERVICE
		buscarCategorias();
		limparComponentes();
	}
	
}
