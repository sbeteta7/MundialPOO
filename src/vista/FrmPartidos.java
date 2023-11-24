package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.appmundial.bo.PartidosBO;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class FrmPartidos extends JFrame {

	private JPanel contentPane;
	private JTextField secondTeam;
	private JTextField firstTeam;
	private JTextField dateGame;
	private JTextField Stadium;
	private JTextField Arbitro_name;
	JScrollPane scrollPane = new JScrollPane();
	JTable tbPartidos = new JTable();
	
	PartidosBO Matchbo = new PartidosBO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FrmPartidos p= new FrmPartidos();
		p.setVisible(true);
	}

	public void listar() {
		Matchbo.listarPartidos(tbPartidos);
	}
	
	/**
	 * Create the frame.
	 */
	public FrmPartidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRAR PARTIDOS");
		lblNewLabel.setBounds(357, 11, 154, 22);
		contentPane.add(lblNewLabel);
		
		JPanel panel =  new JPanel();
		panel.setBounds(46, 44, 794, 229);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Primera selección:");
		lblNewLabel_1.setBounds(34, 21, 100, 14);
		panel.add(lblNewLabel_1);
		
		secondTeam = new JTextField();
		secondTeam.setBounds(34, 102, 176, 20);
		panel.add(secondTeam);
		secondTeam.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Segunda selección:");
		lblNewLabel_1_1.setBounds(34, 77, 100, 14);
		panel.add(lblNewLabel_1_1);
		
		firstTeam = new JTextField();
		firstTeam.setColumns(10);
		firstTeam.setBounds(34, 46, 176, 20);
		panel.add(firstTeam);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Partido pendiente");
		rdbtnNewRadioButton.setBounds(34, 134, 145, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Partido terminado");
		rdbtnNewRadioButton_1.setBounds(190, 134, 176, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Fecha:");
		lblNewLabel_1_1_2.setBounds(396, 21, 91, 14);
		panel.add(lblNewLabel_1_1_2);
		
		dateGame = new JTextField();
		dateGame.setBounds(488, 18, 157, 20);
		panel.add(dateGame);
		dateGame.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Estadio:");
		lblNewLabel_1_1_1_2.setBounds(396, 50, 100, 14);
		panel.add(lblNewLabel_1_1_1_2);
		
		Stadium = new JTextField();
		Stadium.setBounds(488, 47, 157, 20);
		panel.add(Stadium);
		Stadium.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Arbitro:");
		lblNewLabel_1_1_1_2_1.setBounds(396, 75, 100, 14);
		panel.add(lblNewLabel_1_1_1_2_1);
		
		Arbitro_name = new JTextField();
		Arbitro_name.setBounds(488, 75, 157, 20);
		panel.add(Arbitro_name);
		Arbitro_name.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fase:");
		lblNewLabel_1_2.setBounds(396, 112, 100, 14);
		panel.add(lblNewLabel_1_2);
		
		JComboBox Fase = new JComboBox();
		Fase.setBounds(488, 108, 157, 22);
		panel.add(Fase);
		
		Button buttonAgregar = new Button("Agregar");
		buttonAgregar.setBounds(34, 183, 130, 22);
		panel.add(buttonAgregar);
		
		Button buttonEliminar = new Button("Eliminar");
		buttonEliminar.setBounds(197, 183, 130, 22);
		panel.add(buttonEliminar);
		
		Button buttonLimpiar = new Button("Limpiar");
		buttonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonLimpiar.setBounds(693, 17, 91, 22);
		panel.add(buttonLimpiar);
		
		Button buttonSalir = new Button("Salir");
		buttonSalir.setBounds(663, 183, 108, 22);
		panel.add(buttonSalir);
		
		Button buttonConfirmar = new Button("Modificar");
		buttonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonConfirmar.setBounds(376, 183, 111, 22);
		panel.add(buttonConfirmar);
		
		Button buttonModificar = new Button("Confirmar");
		buttonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonModificar.setBounds(516, 183, 111, 22);
		panel.add(buttonModificar);
		
		
		scrollPane.setBounds(46, 284, 794, 278);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tbPartidos);

		listar();
	}
}
