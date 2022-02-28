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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Toolkit;

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
	public JButton btnRegister;
	public JComboBox comboResidencia;
	public JTextArea textArea;
	public JMenuItem mntmAgregarNota;
	public JMenuItem mntmReinciarNmeroDe;
	public JMenuItem mntmExportarFichas;
	private JScrollPane jScrollPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterSolicitudIngreso.class.getResource("/com/cbtis91/resources/logo_cbtis.jpg")));
		setTitle("CBTis91 Registro de Fichas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1139, 861);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 12, 1119, 	812);
		//contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(12, 33, 148, 23);
		panel.add(lblNombres);

		txtNames = new JTextField();
		txtNames.setName("Nombre");
		txtNames.setBounds(225, 35, 235, 19);
		panel.add(txtNames);
		txtNames.setColumns(10);

		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setBounds(12, 97, 148, 23);
		panel.add(lblApellidoPaterno);

		txtLastaName = new JTextField();
		txtLastaName.setName("Apellido paterno");
		txtLastaName.setBounds(225, 99, 235, 19);
		panel.add(txtLastaName);
		txtLastaName.setColumns(10);

		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setBounds(12, 156, 148, 15);
		panel.add(lblApellidoMaterno);

		txtSecondLastName = new JTextField();
		txtSecondLastName.setName("Apellido materno");
		txtSecondLastName.setBounds(225, 154, 235, 19);
		panel.add(txtSecondLastName);
		txtSecondLastName.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(12, 216, 148, 19);
		panel.add(lblEdad);

		txtAge = new JTextField();
		txtAge.setName("Edad");
		txtAge.setBounds(225, 216, 235, 19);
		panel.add(txtAge);
		txtAge.setColumns(10);

		JLabel lblCurp = new JLabel("CURP");
		lblCurp.setBounds(12, 289, 70, 15);
		panel.add(lblCurp);

		txtCurp = new JTextField();
		txtCurp.setName("CURP");
		txtCurp.setBounds(225, 287, 235, 19);
		panel.add(txtCurp);
		txtCurp.setColumns(10);

		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(12, 422, 107, 15);
		panel.add(lblDireccin);

		txtAddress = new JTextField();
		txtAddress.setName("Dirección");
		txtAddress.setBounds(225, 420, 235, 19);
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
		lblrequerido_5.setBounds(225, 448, 175, 15);
		panel.add(lblrequerido_5);

		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico");
		lblCorreoElectrnico.setBounds(599, 28, 235, 15);
		panel.add(lblCorreoElectrnico);

		txtEmail = new JTextField();
		txtEmail.setName("Correo electrónico");
		txtEmail.setBounds(880, 24, 217, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNmeroDeTelfono = new JLabel("Número de teléfono");
		lblNmeroDeTelfono.setBounds(599, 84, 235, 15);
		panel.add(lblNmeroDeTelfono);

		txtContact = new JTextField();
		txtContact.setName("Número de contacto");
		txtContact.setBounds(880, 80, 217, 19);
		panel.add(txtContact);
		txtContact.setColumns(10);

		JLabel lblrequerido_1_1 = new JLabel("*Requerido");
		lblrequerido_1_1.setForeground(Color.RED);
		lblrequerido_1_1.setBounds(880, 105, 173, 15);
		panel.add(lblrequerido_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lenguaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(599, 130, 498, 115);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblEspecfique = new JLabel("Específique");
		lblEspecfique.setEnabled(false);
		lblEspecfique.setBounds(12, 72, 114, 23);
		panel_1.add(lblEspecfique);

		comboDetails = new JComboBox(); //TODO cargar datos desde base de datos 
		comboDetails.setEnabled(false);
		comboDetails.setBounds(293, 72, 193, 23);
		panel_1.add(comboDetails);
		
		JLabel lblLanguaje = new JLabel("¿Habla alguna lengua indígena?");
		lblLanguaje.setBounds(12, 18, 235, 23);
		panel_1.add(lblLanguaje);

		comboLanguaje = new JComboBox();
		comboLanguaje.setBounds(293, 12, 193, 23);
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
		lblLugarDeNacimiento.setBounds(12, 489, 159, 15);
		panel.add(lblLugarDeNacimiento);

		txtBirthLocation = new JTextField();
		txtBirthLocation.setName("Lugar de nacimiento");
		txtBirthLocation.setBounds(225, 487, 235, 19);
		panel.add(txtBirthLocation);
		txtBirthLocation.setColumns(10);

		JLabel lblrequerido_5_1 = new JLabel("*Requerido");
		lblrequerido_5_1.setForeground(Color.RED);
		lblrequerido_5_1.setBounds(225, 518, 175, 15);
		panel.add(lblrequerido_5_1);

		JLabel lblOpcinDe = new JLabel("Opción 1 de especialidad");
		lblOpcinDe.setBounds(12, 550, 194, 15);
		panel.add(lblOpcinDe);

		comboSpecialty = new JComboBox();
		comboSpecialty.setBounds(225, 545, 235, 20);
		panel.add(comboSpecialty);

		JLabel lblrequerido_5_1_1 = new JLabel("*Requerido");
		lblrequerido_5_1_1.setForeground(Color.RED);
		lblrequerido_5_1_1.setBounds(225, 577, 175, 15);
		panel.add(lblrequerido_5_1_1);

		JLabel lblOpcinDe_2 = new JLabel("Opción 2 de especialidad");
		lblOpcinDe_2.setBounds(12, 616, 194, 15);
		panel.add(lblOpcinDe_2);

		comboSpecialty2 = new JComboBox(); // TODO traer datos de base de datos
		comboSpecialty2.setBounds(225, 611, 235, 20);
		panel.add(comboSpecialty2);

		JLabel lblrequerido_5_1_1_1 = new JLabel("*Requerido");
		lblrequerido_5_1_1_1.setForeground(Color.RED);
		lblrequerido_5_1_1_1.setBounds(225, 643, 175, 15);
		panel.add(lblrequerido_5_1_1_1);

		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(599, 489, 70, 15);
		panel.add(lblNota);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(710, 496, 387, 162);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Discapacidad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(599, 273, 498, 130);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblpresentaAlgunaDiscapacidad = new JLabel("¿Presenta alguna discapacidad?");
		lblpresentaAlgunaDiscapacidad.setBounds(12, 30, 245, 15);
		panel_2.add(lblpresentaAlgunaDiscapacidad);
		
		comboDiscapacidad = new JComboBox();
		comboDiscapacidad.setModel(new DefaultComboBoxModel(new String[] {"Ninguno","Si","No"}));
		comboDiscapacidad.setBounds(296, 25, 190, 24);
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
		comboDetailsDisability.setBounds(293, 79, 193, 23);
		panel_2.add(comboDetailsDisability);
		
		JLabel lblTipoDeSecundaria = new JLabel("Tipo de secundaria");
		lblTipoDeSecundaria.setBounds(609, 421, 159, 15);
		panel.add(lblTipoDeSecundaria);
		
		comboSchoolType = new JComboBox();
		comboSchoolType.setModel(new DefaultComboBoxModel(new String[] {"Técnica","General","Telesecundaria"}));
		comboSchoolType.setBounds(904, 416, 193, 23);
		panel.add(comboSchoolType);
		
		JLabel lblrequerido_1_2_1_1 = new JLabel("*Requerido");
		lblrequerido_1_2_1_1.setForeground(Color.RED);
		lblrequerido_1_2_1_1.setBounds(904, 448, 149, 15);
		panel.add(lblrequerido_1_2_1_1);
		
		btnRegister = new JButton("Registrar");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBackground(new Color(0, 0, 153));
		btnRegister.setBounds(461, 715, 152, 36);
		panel.add(btnRegister);
		
		JLabel lblrequerido_1_1_1 = new JLabel("*Requerido");
		lblrequerido_1_1_1.setForeground(Color.RED);
		lblrequerido_1_1_1.setBounds(880, 56, 173, 15);
		panel.add(lblrequerido_1_1_1);
		
		JLabel lblResidenciaActual = new JLabel("Residencia actual");
		lblResidenciaActual.setBounds(12, 362, 159, 15);
		panel.add(lblResidenciaActual);
		
		comboResidencia = new JComboBox();
		comboResidencia.setBounds(225, 362, 235, 20);
		panel.add(comboResidencia);

		JMenuBar menuBar = new JMenuBar(); // Window menu bar
		JMenu fileMenu = new JMenu("Opciones"); // Create File menu
	    JMenu elementMenu = new JMenu("Ayuda"); // Create Elements menu
	    menuBar.add(fileMenu); // Add the file menu
	    
	    mntmAgregarNota = new JMenuItem("Agregar nota");
	    fileMenu.add(mntmAgregarNota);
	    
	    mntmReinciarNmeroDe = new JMenuItem("Reinciar número de ficha");
	    fileMenu.add(mntmReinciarNmeroDe);
	    
	    mntmExportarFichas = new JMenuItem("Exportar fichas generadas");
	    fileMenu.add(mntmExportarFichas);
	    menuBar.add(elementMenu); // Add the element menu
	    
	    setJMenuBar(menuBar);
	    
	    jScrollPane= new JScrollPane();
	    jScrollPane.setBounds(5, 10, getWidth(), getHeight());
	    
	    panel.setPreferredSize(new Dimension(1119, 800));
	    jScrollPane.setViewportView(panel);
	    getContentPane().add(jScrollPane);
	    
	    addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				jScrollPane.setBounds(5, 10, e.getComponent().getWidth()-25, e.getComponent().getHeight()-80);
			}
		});
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
