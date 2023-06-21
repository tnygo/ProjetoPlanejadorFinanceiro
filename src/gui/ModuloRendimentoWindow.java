package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import service.Categoria;
import service.Despesa;
import service.ModuloDespesas;
import service.ModuloRendimento;
import service.Rendimento;

import javax.swing.border.EtchedBorder;

public class ModuloRendimentoWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField_1NovoNome;
	private JTextField txtCadasCate;
	private JTextField textField_3Nome;
	private JComboBox comboBoxEditarCategoria;
	private JMenu mnNewMenuAjuda;
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
	
	private ModuloRendimento moduloRendimento;
	private JLabel lblNewLabel_6;
	private JFormattedTextField txtValorDespesa;
	private JLabel lblNewLabel_5Valor;
	private JFormattedTextField formattedTextField;
	private JMenuBar menuBar;
	private JMenu mnNewSobre;
	private JMenu mnAjuda;
	private JMenuItem mntmVoltar;
	private JMenuItem mntmSair;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public ModuloRendimentoWindow() throws SQLException, IOException {
		
		this.initComponents();
		
		this.moduloRendimento = new ModuloRendimento();
		
		this.buscarCategorias();
		this.buscarRendimentos();
		this.limparComponentes();
		
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewSobre = new JMenu("Sobre");
		menuBar.add(mnNewSobre);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Créditos");
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
		panel.setBounds(35, 51, 677, 125);
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
		lblNewLabel.setBounds(21, 21, 177, 13);
		panel.add(lblNewLabel);
		
		lblNewLabelEditarCategoria = new JLabel("Editar Categoria");
		lblNewLabelEditarCategoria.setBounds(271, 21, 166, 13);
		panel.add(lblNewLabelEditarCategoria);
		
		separator = new JSeparator();
		separator.setBounds(207, 10, 2, 105);
		panel.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 0, 0));
		
		lblNewLabelSelecione = new JLabel("Categoria");
		lblNewLabelSelecione.setBounds(216, 44, 73, 13);
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
		lblNewLabelExcluirCategoria.setBounds(509, 21, 158, 13);
		panel.add(lblNewLabelExcluirCategoria);
		
		lblNewLabel_2SelecioarCategoria = new JLabel("Categoria");
		lblNewLabel_2SelecioarCategoria.setBounds(455, 57, 132, 13);
		panel.add(lblNewLabel_2SelecioarCategoria);
		
		comboBox = new JComboBox();
		comboBox.setBounds(540, 53, 127, 21);
		panel.add(comboBox);
		
		lblNewLabelModuloDespesa = new JLabel("Módulo Rendimento");
		lblNewLabelModuloDespesa.setBounds(324, 28, 111, 13);
		lblNewLabelModuloDespesa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabelModuloDespesa);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rendimento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(35, 186, 677, 208);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Cadastrar Rendimento");
		lblNewLabel_2.setBounds(36, 20, 164, 13);
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
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!", "Cadastrar Rendimento", JOptionPane.INFORMATION_MESSAGE);
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
		
		lblNewLabelEditarDespesa = new JLabel("Editar Rendimento");
		lblNewLabelEditarDespesa.setBounds(280, 20, 135, 13);
		panel_1.add(lblNewLabelEditarDespesa);
		
		lblNewLabel_4SelecDespesa = new JLabel("Rendimento");
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
					JOptionPane.showMessageDialog(null, "Rendimento editado com sucesso!", "Editar Rendimento", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonEditar.setBounds(259, 177, 156, 21);
		panel_1.add(btnNewButtonEditar);
		
		lblNewLabel_6ExcluirDes = new JLabel("Excluir Rendimento");
		lblNewLabel_6ExcluirDes.setBounds(516, 20, 113, 13);
		panel_1.add(lblNewLabel_6ExcluirDes);
		
		lblNewLabel_6SelDes = new JLabel("Rendimento");
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
					JOptionPane.showMessageDialog(null, "Rendimento excluído com sucesso!", "Excluir Rendimento", JOptionPane.INFORMATION_MESSAGE);
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

		Rendimento rendimento = new Rendimento();
		Rendimento r = (Rendimento) comboBox_2.getSelectedItem();
		rendimento.setRendimento_id(r.getRendimento_id());
		this.moduloRendimento.excluirRendimento(rendimento);
		buscarRendimentos();
	}

	protected void btnNewButtonEditar() throws SQLException, IOException {

		Rendimento rendimento = new Rendimento();
		Rendimento r = (Rendimento) comboBox_2SeleDesp.getSelectedItem();
		Categoria categoria = (Categoria) comboBox_3SelecCat.getSelectedItem();
		rendimento.setCategoria(categoria);
		rendimento.setCategoria_id(categoria.getCategoria_id());
		rendimento.setRendimento(textField_3Nome.getText());
		rendimento.setRendimento_id(r.getRendimento_id());
		
		if(rdbtnNewRadioButton.isSelected()) {
			
			rendimento.setValorMensal(Double.parseDouble(formattedTextField.getText()));
			rendimento.setValorTotal((rendimento.getValorMensal()*12));
		} if (rdbtnNewRadioButton_1.isSelected()) {
			
			rendimento.setValorOcasional(Double.parseDouble(formattedTextField.getText()));
			rendimento.setValorTotal(rendimento.getValorOcasional());
		}
		
		this.moduloRendimento.editarRendimento(rendimento);
		
		buscarRendimentos();
		limparComponentes();
	}

	protected void btnNewButtonCadastrar() throws SQLException, IOException {

		Rendimento rendimento = new Rendimento();
		Categoria categoria = (Categoria) cBCategoria.getSelectedItem();
		rendimento.setCategoria(categoria);
		rendimento.setCategoria_id(categoria.getCategoria_id());
		rendimento.setRendimento(txtCadasCate.getText());
		
		if(rdbtnNewRadioButtonMensal.isSelected()) {
			
			rendimento.setValorMensal(Double.parseDouble(txtValorDespesa.getText()));
			rendimento.setValorTotal((rendimento.getValorMensal()*12));
			
		} if (rdbtnNewRadioButtonOcasional.isSelected()) {
			
			rendimento.setValorOcasional(Double.parseDouble(txtValorDespesa.getText()));
			rendimento.setValorTotal(rendimento.getValorOcasional());
		}
		
		this.moduloRendimento.cadastrarNovoRendimento(rendimento);
		buscarRendimentos();
		limparComponentes();
	}

	public void buscarCategorias() throws SQLException, IOException {
		
		List<Categoria> categorias = this.moduloRendimento.buscarCategoria();
		
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
	
	public void buscarRendimentos() throws SQLException, IOException {
		
		List<Rendimento> rendimentos = this.moduloRendimento.buscarRendimento();
		
		comboBox_2SeleDesp.removeAllItems();
		comboBox_2.removeAllItems();
		for (Rendimento rendimento : rendimentos) {
			
			comboBox_2SeleDesp.addItem(rendimento);
			comboBox_2.addItem(rendimento);
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
		this.moduloRendimento.excluirCategoria(categoria);
		comboBox.removeAllItems();
		buscarCategorias();
		
	}

	protected void btnNewButtonEditarCategoria() throws SQLException, IOException {

		Categoria categoria = new Categoria();
		categoria.setCategoria(this.textField_1NovoNome.getText());
		Categoria c = (Categoria) comboBoxEditarCategoria.getSelectedItem();
		categoria.setCategoria_id(c.getCategoria_id());
		this.moduloRendimento.editarCategoria(categoria);
		buscarCategorias();
		limparComponentes();
	}

	protected void btnNewButtonCadastrarCategoria() throws SQLException, IOException {
		
		Categoria categoria = new Categoria(); //CRIANDO OBJETO CATEGORIA 
		categoria.setCategoria(this.txtNome.getText()); //COLETANDO INFORMAÇÕES DO CAMPO TEXTO
		this.moduloRendimento.cadastrarNovaCategoria(categoria); //ENVIANDO O OBJETO AO PACOTE SERVICE
		buscarCategorias();
		limparComponentes();
	}
	
}
