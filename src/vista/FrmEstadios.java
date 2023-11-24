package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.appmundial.bo.EstadioBO;
import modelo.Estadios;



public class FrmEstadios extends JFrame {

	public JPanel contentPane;
	public JTextField textEstadio;
	public JTextField textLugar;
	JScrollPane scrollPane = new JScrollPane();
	JTable tableEstadios =new JTable();
	EstadioBO Ebo = new EstadioBO();
	ButtonGroup buttonGroupEstadios = new ButtonGroup();
	JRadioButton rdbtnCero = new JRadioButton("Inhabilitado");
	JRadioButton rdbtnUno = new JRadioButton("Habilitado");

	Estadios getEstadioID= new Estadios();
	

	
	public static void main(String[] args) {
		FrmEstadios e= new FrmEstadios();
		e.setVisible(true);
	}

	public void listar() {
		Ebo.listarEstadios(tableEstadios);
	}
	
	public void limpiar() {

		textEstadio.setText("");
		textLugar.setText("");
		buttonGroupEstadios.clearSelection();
	}
		
	public void agregar() {

		if(textEstadio.getText().isEmpty()||textLugar.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}
			Estadios estadio=new Estadios();
			estadio.setNombre(textEstadio.getText());
			estadio.setLugar(textLugar.getText());
			estadio.setEstado(estado);

			
			String mensaje= Ebo.agregarEstadios(estadio);
			JOptionPane.showMessageDialog(null, mensaje);
			limpiar();
			listar();
		};
		
	}
	
	public void eliminar() {
		if(textEstadio.getText().isEmpty()||textLugar.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			Estadios estadio=new Estadios();
			estadio.setNombre(textEstadio.getText());
			estadio.setLugar(textLugar.getText());
			estadio.setId_estadio(Ebo.estadioID(estadio));
			
			String mensaje=Ebo.eliminarEstadios(estadio);
			JOptionPane.showMessageDialog(null, mensaje);
			limpiar();
			listar();	
		};
	}
	
	public void modificar() {
		if(textEstadio.getText().isEmpty()||textLugar.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}		

			getEstadioID.setNombre(textEstadio.getText());
			getEstadioID.setLugar(textLugar.getText());
			getEstadioID.setEstado(estado);
			
			getEstadioID.setId_estadio(Ebo.estadioID(getEstadioID));

	}}
	
	public void confirmar() {
		if(textEstadio.getText().isEmpty()||textLugar.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}		
			Estadios estadio=new Estadios();
			estadio.setNombre(textEstadio.getText());
			estadio.setLugar(textLugar.getText());
			estadio.setEstado(estado);
			
			estadio.setId_estadio(Ebo.estadioID(getEstadioID));
			String mensaje=Ebo.modificarEstadios(estadio);

			JOptionPane.showMessageDialog(null, mensaje);
			
			limpiar();
			listar();

			
		};
	}
	

	
	
	public FrmEstadios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRAR SEDES");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 32));
		lblNewLabel.setBounds(172, 11, 349, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(24, 72, 594, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Estadio:");
		lblNewLabel_1.setBounds(32, 18, 61, 20);
		panel.add(lblNewLabel_1);
		
		textEstadio = new JTextField();
		textEstadio.setBounds(103, 18, 124, 20);
		panel.add(textEstadio);
		textEstadio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Lugar:");
		lblNewLabel_2.setBounds(32, 52, 46, 14);
		panel.add(lblNewLabel_2);
		
		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(103, 49, 124, 20);
		panel.add(textLugar);
		
		JLabel lblNewLabel_3 = new JLabel("Estado:");
		lblNewLabel_3.setBounds(324, 21, 46, 14);
		panel.add(lblNewLabel_3);
		

		buttonGroupEstadios.add(rdbtnCero);
		rdbtnCero.setBounds(393, 44, 109, 23);
		panel.add(rdbtnCero);
		

		buttonGroupEstadios.add(rdbtnUno);
		rdbtnUno.setBounds(393, 18, 109, 23);
		panel.add(rdbtnUno);
		
		Button buttonAgregar = new Button("Agregar");
		buttonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		buttonAgregar.setBounds(32, 84, 101, 22);
		panel.add(buttonAgregar);
		
		Button buttonModificar = new Button("Confirmar");
		buttonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmar();
			}
		});
		buttonModificar.setBounds(151, 84, 82, 22);
		panel.add(buttonModificar);
		
		Button buttonEliminar = new Button("Eliminar");
		buttonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		buttonEliminar.setBounds(248, 84, 101, 22);
		panel.add(buttonEliminar);
		
		Button buttonLimpiar = new Button("Limpiar");
		buttonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		buttonLimpiar.setBounds(370, 85, 91, 22);
		panel.add(buttonLimpiar);
		
		Button buttonSalir = new Button("Salir");
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		buttonSalir.setBounds(476, 84, 91, 22);
		panel.add(buttonSalir);
		
		Button buttonConfirmar = new Button("Modificar");
		buttonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		buttonConfirmar.setBounds(233, 16, 82, 22);
		panel.add(buttonConfirmar);
		

		scrollPane.setBounds(24, 199, 594, 187);
		contentPane.add(scrollPane);
		tableEstadios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila=tableEstadios.rowAtPoint(e.getPoint());
				textEstadio.setText(tableEstadios.getValueAt(fila,0)+"");
				textLugar.setText(tableEstadios.getValueAt(fila,1)+"");
	
				String estado = tableEstadios.getValueAt(fila,2)+"";
				if (estado.equals("1")) {
					rdbtnUno.setSelected(true);
				}else {
					rdbtnCero.setSelected(true);
				}

		}});
		

		scrollPane.setColumnHeaderView(tableEstadios);
		listar();
	}

}
