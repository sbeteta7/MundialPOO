package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.appmundial.bo.PaisBO;

import modelo.Pais;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmPais extends JFrame {

	public JPanel contentPane;
	public JTextField textPais;
	public JTextField textGrupo;
	JScrollPane scrollPane = new JScrollPane();
	JTable tablePais =new JTable();
	PaisBO Pbo = new PaisBO();
	ButtonGroup buttonGroupPais = new ButtonGroup();
	JRadioButton rdbtnCero = new JRadioButton("Descalificado");
	JRadioButton rdbtnUno = new JRadioButton("En competencia");

	Pais getPaisID= new Pais();
	
	public void confirmar() {
		if(textPais.getText().isEmpty()||textGrupo.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}		

			getPaisID.setNombre(textPais.getText());
			getPaisID.setGrupo(textGrupo.getText());
			getPaisID.setEstado(estado);
			
			getPaisID.setIdPais(Pbo.paisID(getPaisID));

	}}
	
	public static void main(String[] args) {
		FrmPais p= new FrmPais();
		p.setVisible(true);
	}

	public void listar() {
		Pbo.listarPais(tablePais);
	}
	
	public void limpiar() {

		textPais.setText("");
		textGrupo.setText("");
		buttonGroupPais.clearSelection();
	}
		
	public void agregar() {

		if(textPais.getText().isEmpty()||textGrupo.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}
			Pais pais=new Pais();
			pais.setNombre(textPais.getText());
			pais.setGrupo(textGrupo.getText());
			pais.setEstado(estado);

			
			String mensaje= Pbo.agregarPais(pais);
			JOptionPane.showMessageDialog(null, mensaje);
			limpiar();
			listar();
		};
		
	}
	
	public void eliminar() {
		if(textPais.getText().isEmpty()||textGrupo.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			Pais pais=new Pais();
			pais.setNombre(textPais.getText());
			pais.setGrupo(textGrupo.getText());
			pais.setIdPais(Pbo.paisID(pais));
			
			String mensaje=Pbo.eliminarPais(pais);
			JOptionPane.showMessageDialog(null, mensaje);
			limpiar();
			listar();	
		};
	}
	
	public void modificar() {
		if(textPais.getText().isEmpty()||textGrupo.getText().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Completar todos los campos");
		}else{
			String estado;
			if(rdbtnCero.isSelected()) {
				estado="0";
			}else {
				estado="1";
			}		
			Pais pais=new Pais();
			pais.setNombre(textPais.getText());
			pais.setGrupo(textGrupo.getText());
			pais.setEstado(estado);
			
			pais.setIdPais(Pbo.paisID(getPaisID));
			String mensaje= Pbo.modificarPais(pais);

			JOptionPane.showMessageDialog(null, mensaje);
			
			limpiar();
			listar();

			
		};
	}
	

	
	
	public FrmPais() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRAR PAISES");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 32));
		lblNewLabel.setBounds(172, 11, 349, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(24, 72, 594, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("País:");
		lblNewLabel_1.setBounds(32, 18, 61, 20);
		panel.add(lblNewLabel_1);
		
		textPais = new JTextField();
		textPais.setBounds(103, 18, 124, 20);
		panel.add(textPais);
		textPais.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Grupo:");
		lblNewLabel_2.setBounds(32, 52, 46, 14);
		panel.add(lblNewLabel_2);
		
		textGrupo = new JTextField();
		textGrupo.setColumns(10);
		textGrupo.setBounds(103, 49, 124, 20);
		panel.add(textGrupo);
		
		JLabel lblNewLabel_3 = new JLabel("Estado:");
		lblNewLabel_3.setBounds(324, 21, 46, 14);
		panel.add(lblNewLabel_3);
		

		buttonGroupPais.add(rdbtnCero);
		rdbtnCero.setBounds(393, 44, 109, 23);
		panel.add(rdbtnCero);
		

		buttonGroupPais.add(rdbtnUno);
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
				modificar();
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
				confirmar();
			}
		});
		buttonConfirmar.setBounds(233, 16, 82, 22);
		panel.add(buttonConfirmar);
		

		scrollPane.setBounds(24, 199, 594, 187);
		contentPane.add(scrollPane);
		tablePais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila=tablePais.rowAtPoint(e.getPoint());
				textPais.setText(tablePais.getValueAt(fila,0)+"");
				textGrupo.setText(tablePais.getValueAt(fila,1)+"");
	
				String estado = tablePais.getValueAt(fila,2)+"";
				if (estado.equals("1")) {
					rdbtnUno.setSelected(true);
				}else {
					rdbtnCero.setSelected(true);
				}

		}});
		

		scrollPane.setViewportView(tablePais);
		listar();
	}
}
