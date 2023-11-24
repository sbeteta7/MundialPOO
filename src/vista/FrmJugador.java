package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTable;
import com.appmundial.bo.JugadorBO;

import modelo.Jugador;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmJugador extends javax.swing.JFrame {

	public JPanel contentPane;
	public JTextField textNombres;
	public JTextField textApellidos;
	public JTextField textPais;
	public JTextField textPosicion;
	public JTextField textEdad;
	JRadioButton rdbtnUno = new JRadioButton("En competencia");
	JRadioButton rdbtnCero = new JRadioButton("Inhabilitado");
	ButtonGroup g1= new ButtonGroup();
	JTable tbJugador = new JTable();
	JScrollPane scrollPane = new JScrollPane();
	
	JugadorBO Jbo = new JugadorBO();
	Jugador getJugadorID= new Jugador();
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FrmJugador v =new FrmJugador();
		v.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public void limpiar() {

		textPais.setText("");
		textNombres.setText("");
		textApellidos.setText("");
		textPosicion.setText("");
		textEdad.setText("");
		g1.clearSelection();
	}
		
	public void agregar() {

		if(textPais.getText().isEmpty()||textNombres.getText().isEmpty()
				||textApellidos.getText().isEmpty()||textEdad.getText().isEmpty()
				||textPosicion.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}
			Jugador player=new Jugador();
			player.setPais(textPais.getText());
			player.setNombres(textNombres.getText());
			player.setApellidos(textApellidos.getText());
			player.setPosicion(textPosicion.getText());
			player.setEstado(estado);
			player.setEdad(Integer.parseInt(textEdad.getText()));
			
			String mensaje= Jbo.agregarJugador(player);
			JOptionPane.showMessageDialog(null, mensaje);
			limpiar();
			listar();

			
		};
		
	}
	
	public void eliminar() {
		if(textPais.getText().isEmpty()||textNombres.getText().isEmpty()
				||textApellidos.getText().isEmpty()||textEdad.getText().isEmpty()
				||textPosicion.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			Jugador player=new Jugador();
			player.setNombres(textNombres.getText());
			player.setApellidos(textApellidos.getText());
			player.setPosicion(textPosicion.getText());
			player.setEdad(Integer.parseInt(textEdad.getText()));
			player.setId_jugador(Jbo.jugadorID(player));
			String mensaje=Jbo.eliminarJugador(player);
			JOptionPane.showMessageDialog(null, mensaje);
			limpiar();
			listar();	
		};
	}
	
	
	public void modificar() {
		if(textPais.getText().isEmpty()||textNombres.getText().isEmpty()
				||textApellidos.getText().isEmpty()||textEdad.getText().isEmpty()
				||textPosicion.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}			
		
		getJugadorID.setPais(textPais.getText());
		getJugadorID.setNombres(textNombres.getText());
		getJugadorID.setApellidos(textApellidos.getText());
		getJugadorID.setPosicion(textPosicion.getText());
		getJugadorID.setEstado(estado);
		getJugadorID.setEdad(Integer.parseInt(textEdad.getText()));
		
		getJugadorID.setId_jugador(Jbo.jugadorID(getJugadorID));
	}}
	
	
	public void confirmar() {
		if(textPais.getText().isEmpty()||textNombres.getText().isEmpty()
				||textApellidos.getText().isEmpty()||textEdad.getText().isEmpty()
				||textPosicion.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}		
			Jugador player=new Jugador();
			
			player.setPais(textPais.getText());
			player.setNombres(textNombres.getText());
			player.setApellidos(textApellidos.getText());
			player.setPosicion(textPosicion.getText());
			player.setEstado(estado);
			player.setEdad(Integer.parseInt(textEdad.getText()));

			player.setId_jugador(Jbo.jugadorID(getJugadorID));;
			
			String mensaje=Jbo.modificarJugador(player);
			JOptionPane.showMessageDialog(null, mensaje);
			
			limpiar();
			listar();
			
		};
	}
	
	public void listar() {
		Jbo.listarJugador(tbJugador);
	}
	

	
	public FrmJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(49, 60, 643, 186);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(34, 26, 91, 14);
		panel.add(lblNombres);
		
		textNombres = new JTextField();
		textNombres.setBounds(135, 20, 199, 20);
		panel.add(textNombres);
		textNombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(34, 51, 91, 14);
		panel.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(135, 45, 199, 20);
		panel.add(textApellidos);
		
		textPais = new JTextField();
		textPais.setColumns(10);
		textPais.setBounds(135, 70, 199, 20);
		panel.add(textPais);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(34, 76, 91, 14);
		panel.add(lblPais);
		
		JLabel lblPosicion = new JLabel("Posición:");
		lblPosicion.setBounds(34, 104, 91, 14);
		panel.add(lblPosicion);
		
		textPosicion = new JTextField();
		textPosicion.setBounds(135, 101, 199, 20);
		panel.add(textPosicion);
		textPosicion.setColumns(10);
		
		textEdad = new JTextField();
		textEdad.setBounds(135, 124, 145, 20);
		panel.add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(34, 127, 46, 14);
		panel.add(lblEdad);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(363, 26, 46, 14);
		panel.add(lblEstado);
		

		

		rdbtnUno.setBounds(452, 22, 145, 23);
		panel.add(rdbtnUno);
		

		rdbtnCero.setForeground(Color.BLACK);
		rdbtnCero.setBounds(452, 49, 145, 18);
		panel.add(rdbtnCero);
		
		g1.add(rdbtnCero);
		g1.add(rdbtnUno);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(505, 152, 103, 23);
		panel.add(btnSalir);
		
		JLabel lblNewLabel_6 = new JLabel("Administrar jugadores");
		lblNewLabel_6.setBounds(214, 11, 361, 38);
		lblNewLabel_6.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 32));
		contentPane.add(lblNewLabel_6);
		tbJugador.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int fila=tbJugador.rowAtPoint(e.getPoint());
				textPais.setText(tbJugador.getValueAt(fila,0)+"");
				textNombres.setText(tbJugador.getValueAt(fila,1)+"");
				textApellidos.setText(tbJugador.getValueAt(fila,2)+"");
				String estado = tbJugador.getValueAt(fila,3)+"";
				if (estado.equals("1")) {
					rdbtnUno.setSelected(true);
				}else {
					rdbtnCero.setSelected(true);
				}
				textEdad.setText(tbJugador.getValueAt(fila,4)+"");
				textPosicion.setText(tbJugador.getValueAt(fila,5)+"");	
				
			}
		});
		

		scrollPane.setBounds(49, 257, 643, 188);
		contentPane.add(scrollPane);
		

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(34, 152, 83, 23);
		panel.add(btnAgregar);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		
		
		JButton btnLimpiar = new JButton("Limpiar");	
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();


			}
		});
		
		
		
		btnLimpiar.setBounds(339, 152, 109, 23);
		panel.add(btnLimpiar);
		
		JButton btnActualizar = new JButton("Confirmar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				confirmar();
				
			}
		});
		
	
		btnActualizar.setBounds(379, 104, 97, 21);
		panel.add(btnActualizar);
		
		btnLimpiar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
				
			}
		});
		btnEliminar.setBounds(190, 152, 111, 23);
		panel.add(btnEliminar);
		
		JButton btnConfirmar = new JButton("Modificar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnConfirmar.setBounds(511, 101, 110, 21);
		panel.add(btnConfirmar);

		//Crear tabla tbJugador

		tbJugador.setBackground(Color.WHITE);
		scrollPane.setViewportView(tbJugador);
		//Ejecutar método listarJugador
		listar();

		
	}
}
