package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreditosWindow extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewSobre;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnAjuda;
	private JMenuItem mntmVoltar;
	private JMenuItem mntmSair;
	private JLabel lblTitulo;
	private JLabel lblTitulo_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	public CreditosWindow() {

		initComponents();
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo_1 = new JLabel("UTFinanZ");
		lblTitulo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo_1.setBounds(316, 45, 87, 48);
		contentPane.add(lblTitulo_1);
		
		lblNewLabel = new JLabel("Antony H. Goes dos Santos\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(280, 103, 179, 29);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Prof. Vinícius Camargo Andrade");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(269, 138, 207, 17);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Universidade Tecnológica Federal do Paraná");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(233, 165, 277, 17);
		contentPane.add(lblNewLabel_2);
		
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

	}
}
