package com.cbtis91.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.cbtis91.controller.SolicitudIngresoController;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

@SuppressWarnings("rawtypes")
public class RegisterSolicitudIngreso extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNames;
	public JTextField txtLastaName;
	public JTextField txtSecondLastName;
	public JTextField txtAge;
	public JTextField txtCurp;
	public JTextField txtAddress;
	public JTextField txtEmail;
	public JTextField txtContact;
	public JTextField txtBirthLocation;
	public JComboBox comboSchoolType;
	public JComboBox comboDetailsDisability;
	public JComboBox comboDiscapacidad;
	public JComboBox comboSpecialty2;
	public JComboBox comboSpecialty;
	public JComboBox comboLanguaje;
	public JComboBox comboDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterSolicitudIngreso frame = new RegisterSolicitudIngreso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked" })
	public RegisterSolicitudIngreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 771);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 12, 989, 722);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(12, 33, 148, 23);
		panel.add(lblNombres);

		txtNames = new JTextField();
		txtNames.setBounds(225, 35, 175, 19);
		panel.add(txtNames);
		txtNames.setColumns(10);

		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setBounds(12, 97, 148, 23);
		panel.add(lblApellidoPaterno);

		txtLastaName = new JTextField();
		txtLastaName.setBounds(225, 99, 175, 19);
		panel.add(txtLastaName);
		txtLastaName.setColumns(10);

		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setBounds(12, 156, 148, 15);
		panel.add(lblApellidoMaterno);

		txtSecondLastName = new JTextField();
		txtSecondLastName.setBounds(225, 154, 175, 19);
		panel.add(txtSecondLastName);
		txtSecondLastName.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(12, 216, 148, 19);
		panel.add(lblEdad);

		txtAge = new JTextField();
		txtAge.setBounds(225, 216, 175, 19);
		panel.add(txtAge);
		txtAge.setColumns(10);

		JLabel lblCurp = new JLabel("Curp");
		lblCurp.setBounds(12, 289, 70, 15);
		panel.add(lblCurp);

		txtCurp = new JTextField();
		txtCurp.setBounds(225, 287, 175, 19);
		panel.add(txtCurp);
		txtCurp.setColumns(10);

		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(12, 356, 107, 15);
		panel.add(lblDireccin);

		txtAddress = new JTextField();
		txtAddress.setBounds(225, 354, 175, 19);
		panel.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel lblrequerido = new JLabel("*Requerido");
		lblrequerido.setForeground(Color.RED);
		lblrequerido.setBounds(225, 56, 175, 15);
		panel.add(lblrequerido);

		JLabel lblrequerido_1 = new JLabel("*Requerido");
		lblrequerido_1.setForeground(Color.RED);
		lblrequerido_1.setBounds(225, 130, 175, 15);
		panel.add(lblrequerido_1);

		JLabel lblrequerido_2 = new JLabel("*Requerido");
		lblrequerido_2.setForeground(Color.RED);
		lblrequerido_2.setBounds(225, 183, 175, 15);
		panel.add(lblrequerido_2);

		JLabel lblrequerido_3 = new JLabel("*Requerido");
		lblrequerido_3.setForeground(Color.RED);
		lblrequerido_3.setBounds(225, 247, 175, 15);
		panel.add(lblrequerido_3);

		JLabel lblrequerido_4 = new JLabel("*Requerido");
		lblrequerido_4.setForeground(Color.RED);
		lblrequerido_4.setBounds(225, 311, 175, 15);
		panel.add(lblrequerido_4);

		JLabel lblrequerido_5 = new JLabel("*Requerido");
		lblrequerido_5.setForeground(Color.RED);
		lblrequerido_5.setBounds(225, 382, 175, 15);
		panel.add(lblrequerido_5);

		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico");
		lblCorreoElectrnico.setBounds(486, 28, 235, 15);
		panel.add(lblCorreoElectrnico);

		txtEmail = new JTextField();
		txtEmail.setBounds(767, 24, 173, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNmeroDeTelfono = new JLabel("Número de teléfono");
		lblNmeroDeTelfono.setBounds(486, 76, 235, 15);
		panel.add(lblNmeroDeTelfono);

		txtContact = new JTextField();
		txtContact.setBounds(767, 72, 173, 19);
		panel.add(txtContact);
		txtContact.setColumns(10);

		JLabel lblrequerido_1_1 = new JLabel("*Requerido");
		lblrequerido_1_1.setForeground(Color.RED);
		lblrequerido_1_1.setBounds(767, 97, 173, 15);
		panel.add(lblrequerido_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lenguaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(486, 137, 454, 115);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblEspecfique = new JLabel("Específique");
		lblEspecfique.setEnabled(false);
		lblEspecfique.setBounds(12, 72, 114, 23);
		panel_1.add(lblEspecfique);

		comboDetails = new JComboBox(); //TODO cargar datos desde base de datos 
		comboDetails.setEnabled(false);
		comboDetails.setBounds(293, 72, 149, 23);
		panel_1.add(comboDetails);
		
		JLabel lblLanguaje = new JLabel("¿Habla alguna lengua indígena?");
		lblLanguaje.setBounds(12, 18, 235, 23);
		panel_1.add(lblLanguaje);

		comboLanguaje = new JComboBox();
		comboLanguaje.setBounds(293, 12, 149, 23);
		panel_1.add(comboLanguaje);
		comboLanguaje.setModel(new DefaultComboBoxModel(new String[] { "Ninguno", "Si", "No" }));
		comboLanguaje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboLanguaje.getItemAt(comboLanguaje.getSelectedIndex()).equals("Si")) {
					lblEspecfique.setEnabled(true);
					comboDetails.setEnabled(true);
				} else {
					comboDetails.setEnabled(false);
					lblEspecfique.setEnabled(false);
				}

			}
		});

		JLabel lblrequerido_1_2 = new JLabel("*Requerido");
		lblrequerido_1_2.setBounds(293, 45, 149, 15);
		panel_1.add(lblrequerido_1_2);
		lblrequerido_1_2.setForeground(Color.RED);

		JLabel lblLugarDeNacimiento = new JLabel("Lugar de nacimiento");
		lblLugarDeNacimiento.setBounds(12, 423, 159, 15);
		panel.add(lblLugarDeNacimiento);

		txtBirthLocation = new JTextField();
		txtBirthLocation.setBounds(225, 421, 175, 19);
		panel.add(txtBirthLocation);
		txtBirthLocation.setColumns(10);

		JLabel lblrequerido_5_1 = new JLabel("*Requerido");
		lblrequerido_5_1.setForeground(Color.RED);
		lblrequerido_5_1.setBounds(225, 452, 175, 15);
		panel.add(lblrequerido_5_1);

		JLabel lblOpcinDe = new JLabel("Opción 1 de especialidad");
		lblOpcinDe.setBounds(12, 500, 194, 15);
		panel.add(lblOpcinDe);

		comboSpecialty = new JComboBox();
		comboSpecialty.setBounds(225, 495, 175, 20);
		panel.add(comboSpecialty);

		JLabel lblrequerido_5_1_1 = new JLabel("*Requerido");
		lblrequerido_5_1_1.setForeground(Color.RED);
		lblrequerido_5_1_1.setBounds(225, 527, 175, 15);
		panel.add(lblrequerido_5_1_1);

		JLabel lblOpcinDe_2 = new JLabel("Opción 2 de especialidad");
		lblOpcinDe_2.setBounds(12, 566, 194, 15);
		panel.add(lblOpcinDe_2);

		comboSpecialty2 = new JComboBox(); // TODO traer datos de base de datos
		comboSpecialty2.setBounds(225, 561, 175, 20);
		panel.add(comboSpecialty2);

		JLabel lblrequerido_5_1_1_1 = new JLabel("*Requerido");
		lblrequerido_5_1_1_1.setForeground(Color.RED);
		lblrequerido_5_1_1_1.setBounds(225, 593, 175, 15);
		panel.add(lblrequerido_5_1_1_1);

		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(486, 473, 70, 15);
		panel.add(lblNota);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(553, 473, 387, 135);
		panel.add(scrollPane);
		
				JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Discapacidad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(486, 267, 454, 130);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblpresentaAlgunaDiscapacidad = new JLabel("¿Presenta alguna discapacidad?");
		lblpresentaAlgunaDiscapacidad.setBounds(12, 30, 245, 15);
		panel_2.add(lblpresentaAlgunaDiscapacidad);
		
		comboDiscapacidad = new JComboBox();
		comboDiscapacidad.setModel(new DefaultComboBoxModel(new String[] {"Ninguno","Si","No"}));
		comboDiscapacidad.setBounds(296, 25, 146, 24);
		panel_2.add(comboDiscapacidad);
		
		
		JLabel lblrequerido_1_2_1 = new JLabel("*Requerido");
		lblrequerido_1_2_1.setForeground(Color.RED);
		lblrequerido_1_2_1.setBounds(296, 61, 149, 15);
		panel_2.add(lblrequerido_1_2_1);
		
		JLabel lblEspecfiqueDisability = new JLabel("Específique");
		lblEspecfiqueDisability.setEnabled(false);
		lblEspecfiqueDisability.setBounds(12, 79, 114, 23);
		panel_2.add(lblEspecfiqueDisability);
		
		comboDetailsDisability = new JComboBox();
		comboDetailsDisability.setEnabled(false);
		comboDetailsDisability.setBounds(293, 79, 149, 23);
		panel_2.add(comboDetailsDisability);
		
		JLabel lblTipoDeSecundaria = new JLabel("Tipo de secundaria");
		lblTipoDeSecundaria.setBounds(486, 414, 159, 15);
		panel.add(lblTipoDeSecundaria);
		
		comboSchoolType = new JComboBox();
		comboSchoolType.setModel(new DefaultComboBoxModel(new String[] {"Técnica","General","Telesecundaria"}));
		comboSchoolType.setBounds(781, 409, 159, 23);
		panel.add(comboSchoolType);
		
		JLabel lblrequerido_1_2_1_1 = new JLabel("*Requerido");
		lblrequerido_1_2_1_1.setForeground(Color.RED);
		lblrequerido_1_2_1_1.setBounds(781, 441, 149, 15);
		panel.add(lblrequerido_1_2_1_1);
		
		JButton btnRegister = new JButton("Registrar");
		btnRegister.setBounds(404, 640, 152, 36);
		panel.add(btnRegister);

		comboDiscapacidad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboDiscapacidad.getItemAt(comboDiscapacidad.getSelectedIndex()).equals("Si")) {
					lblEspecfiqueDisability.setEnabled(true);
					comboDetailsDisability.setEnabled(true);
				} else {
					comboDetailsDisability.setEnabled(false);
					lblEspecfiqueDisability.setEnabled(false);
				}

			}
		});
		@SuppressWarnings("unused")
		SolicitudIngresoController controller= new SolicitudIngresoController(this);
	}
}
