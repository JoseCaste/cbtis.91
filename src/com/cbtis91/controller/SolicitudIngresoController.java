package com.cbtis91.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.cbtis91.dao.DAODiscapacidad;
import com.cbtis91.dao.DAOEspecialidad;
import com.cbtis91.dao.DAOFicha;
import com.cbtis91.dao.DAOLengua;
import com.cbtis91.dao.DAOLocalidades;
import com.cbtis91.excelCreator.ExcelCreator;
import com.cbtis91.models.Discapacidad;
import com.cbtis91.models.Especialidad;
import com.cbtis91.models.Lengua;
import com.cbtis91.models.Localidad;
import com.cbtis91.pdfCreater.PdfCreator;
import com.cbtis91.views.RegisterSolicitudIngreso;
import com.cbtis91.views.tab_order.CustomTravelPolicy;


public class SolicitudIngresoController implements ActionListener{

	private RegisterSolicitudIngreso registerSolicitudIngreso;
	private DAOLengua daoLengua;
	private DAODiscapacidad daoDiscapacidad;
	private DAOEspecialidad daoEspecialidad;
	private DAOLocalidades daoLocalidades;
	private DAOFicha daoFicha;
	private int actualYear;
	private static final Logger logger= Logger.getLogger(SolicitudIngresoController.class.getName());
	private List<JTextField> fields; 
	/**
	 * @wbp.parser.entryPoint
	 */
	public SolicitudIngresoController(RegisterSolicitudIngreso registerSolicitudIngreso) {
		this.daoLengua= new DAOLengua();
		this.daoDiscapacidad= new DAODiscapacidad();
		this.daoEspecialidad= new DAOEspecialidad();
		this.daoLocalidades= new DAOLocalidades();
		this.daoFicha= new DAOFicha();
		this.registerSolicitudIngreso = registerSolicitudIngreso;
		this.actualYear=LocalDate.now().getYear();
		this.fields= new ArrayList<>();
		loadComboBoxesResources();
		loadListerners();
		loadMenuListerners();
		loadFields();
		setTabOrder();
	}


	private void setTabOrder() { //Asignando el orden de tab para saltar entre textfields
		Vector<Component> vector= this.fields.stream().map(jtextField->{
			return (Component)jtextField;
		}).collect(Collectors.toCollection(Vector::new));
		
		CustomTravelPolicy customTravelPolicy= new CustomTravelPolicy(vector);
		this.registerSolicitudIngreso.setFocusTraversalPolicy(customTravelPolicy);
	}


	private boolean validateEmptyFields() {
		for (JTextField jTextField : fields) {
			if(jTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo "+jTextField.getName()+" no debe estar vac??o","Error",2);
				return false;
			}
		}
		return true;
		
	}


	private void loadFields() {
		this.fields.add(this.registerSolicitudIngreso.txtNames);
		this.fields.add(this.registerSolicitudIngreso.txtLastaName);
		this.fields.add(this.registerSolicitudIngreso.txtSecondLastName);
		this.fields.add(this.registerSolicitudIngreso.txtAge);
		this.fields.add(this.registerSolicitudIngreso.txtCurp);
		this.fields.add(this.registerSolicitudIngreso.txtAddress);
		this.fields.add(this.registerSolicitudIngreso.txtBirthLocation);
		this.fields.add(this.registerSolicitudIngreso.txtEmail);
		this.fields.add(this.registerSolicitudIngreso.txtContact);
	}


	private void loadMenuListerners() {
		this.registerSolicitudIngreso.mntmAgregarNota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final String nota = JOptionPane.showInputDialog("Ingrese la nota");
				registerSolicitudIngreso.textArea.setText(nota);
				
			}
		});
		this.registerSolicitudIngreso.mntmReinciarNmeroDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int op1= JOptionPane.showConfirmDialog(null, "Confirmaci??n de reinicio de n??mero de fichas","Advertencia",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(op1 == 0) {
					if(daoFicha.resetNumberFichaCounter())
						JOptionPane.showMessageDialog(null, "N??mero de fichas reiniciado con ??xito");
					else 
						JOptionPane.showMessageDialog(null, "No se pudo reiniciar el n??mero de ficha","Error",JOptionPane.YES_OPTION);
				}
			}
		});
		this.registerSolicitudIngreso.mntmExportarFichas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final int op= JOptionPane.showConfirmDialog(null,"Confirmaci??n de exportaci??n de excel","Confirmar",JOptionPane.YES_NO_OPTION); 
				if(op==0) {
					
					if(new ExcelCreator(daoFicha.getAllCustomQuery()).createExcelReport()) 
						
						JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
					else
						
						JOptionPane.showMessageDialog(null, "No se ha creado el reporte o la ruta destino no existe","Error",2);
				}
			}
		});
	}


	private void loadListerners() {
		this.registerSolicitudIngreso.btnRegister.addActionListener(this);
		onlyNumbersTextField();
		onlyEighteenCharactersCURP();
	}


	private void onlyEighteenCharactersCURP() {
		this.registerSolicitudIngreso.txtCurp.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				final JTextField curp= (JTextField) e.getSource();
				
				if(curp.getText().length()!=18) {
					JOptionPane.showMessageDialog(null, "El dato CURP no cumple con los requisitos de longitud","Error",2);
					curp.requestFocus();
				}
			}
			
		});
		
	}


	private void onlyNumbersTextField() {
		this.registerSolicitudIngreso.txtAge.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				//super.keyTyped(e);
				try {
					Integer.parseInt(String.format("%c", e.getKeyChar())); //solo es para detectar si hay un valor no num??rico, en caso de que si, la tecla presionada no es mostrada en el campo
				} catch (NumberFormatException ex2) {
					e.setKeyChar('\0');
				}
			}
			
		});
		validateContactField();
		
	}


	private void validateContactField() {
		this.registerSolicitudIngreso.txtContact.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				try {
					Integer.parseInt(String.format("%c", e.getKeyChar())); //solo es para detectar si hay un valor no num??rico, en caso de que si, la tecla presionada no es mostrada en el campo
				} catch (NumberFormatException ex2) {
					e.setKeyChar('\0');
				}
			}
		
		});
		//cuando el foco sale, verificar si es una extensi??n de 10 digitos el numero de telefono
		this.registerSolicitudIngreso.txtContact.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				JTextField field=(JTextField) e.getSource();
				if(field.getText().length()!=10) {
					JOptionPane.showMessageDialog(null, "El n??mero de contacto deben ser 10 d??gitos");
					field.requestFocus();
				}
			}
		
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("unchecked")
	private void loadComboBoxesResources() {
		//obtiene los lenguajes, los mapea a unicamente los nombres para obtener un arreglo definido de lengujas para el comboBox
		String[] languajes=daoLengua.getAll().stream().map(Lengua::getNombreLengua).collect(Collectors.toList()).stream().toArray(String[]::new);
		
		this.registerSolicitudIngreso.comboDetails.setModel(new DefaultComboBoxModel<>(languajes));
		
		String[] discapacidades= daoDiscapacidad.getAll().stream().map(Discapacidad::getNombreDiscapacidad).collect(Collectors.toList()).toArray(String[]::new);
		
		this.registerSolicitudIngreso.comboDetailsDisability.setModel(new DefaultComboBoxModel<>(discapacidades));
		
		String[] specialties =daoEspecialidad.getAll().stream().map(Especialidad::getName_especialidad).collect(Collectors.toList()).stream().toArray(String[]::new);
		this.registerSolicitudIngreso.comboSpecialty.setModel(new DefaultComboBoxModel<>(specialties));
		this.registerSolicitudIngreso.comboSpecialty2.setModel(new DefaultComboBoxModel<>(specialties));
		
		String[] localidades =daoLocalidades.getAll().stream().map(Localidad::getNombreLocalidad).collect(Collectors.toList()).stream().toArray(String[]::new);
		this.registerSolicitudIngreso.comboResidencia.setModel(new DefaultComboBoxModel<>(localidades));
		
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.registerSolicitudIngreso.btnRegister) {
			if(JOptionPane.showConfirmDialog(null, "Confirmaci??n de generaci??n de ficha","Confirmaci??n",JOptionPane.YES_NO_OPTION)==0) {
				if(validateEmptyFields()){
					try {
						String names= this.registerSolicitudIngreso.txtNames.getText();
						
						String lastName=this.registerSolicitudIngreso.txtLastaName.getText();
						
						String secondLastname=this.registerSolicitudIngreso.txtSecondLastName.getText();
						
						String curp= this.registerSolicitudIngreso.txtCurp.getText();
						
						String address=this.registerSolicitudIngreso.txtAddress.getText();
						
						String email=this.registerSolicitudIngreso.txtEmail.getText();
						
						String op1= this.registerSolicitudIngreso.comboSpecialty.getSelectedItem().toString();
						
						String op2= this.registerSolicitudIngreso.comboSpecialty2.getSelectedItem().toString();
						
						String actualResidencia= this.registerSolicitudIngreso.comboResidencia.getSelectedItem().toString();
						
						String optionalNote=this.registerSolicitudIngreso.textArea.getText();
						
						String contact=this.registerSolicitudIngreso.txtContact.getText();
						
						String birthPlace= this.registerSolicitudIngreso.txtBirthLocation.getText();
						
						int age= Integer.parseInt(this.registerSolicitudIngreso.txtAge.getText());
						
						String selectedCombo= this.registerSolicitudIngreso.comboLanguaje.getSelectedItem().toString();
						String lenguaje= selectedCombo.equals("Si")? this.registerSolicitudIngreso.comboDetails.getSelectedItem().toString() : "Ninguno";
						
						selectedCombo=this.registerSolicitudIngreso.comboDiscapacidad.getSelectedItem().toString();
						String disability= selectedCombo.equals("Si")? this.registerSolicitudIngreso.comboDetailsDisability.getSelectedItem().toString() : "Ninguno";
						
						String kindSchool= this.registerSolicitudIngreso.comboSchoolType.getSelectedItem().toString();
						/*
						 * String names, String lastName, String secondLastName, Integer age, String curp, String address, String birthPlace, String op1Especilty, String op2Especilty, String contact, String languaje, String disability, String kindSchool*/
						PdfCreator pdfCreator= new PdfCreator(names, lastName, secondLastname, age, curp, actualResidencia, address, birthPlace, op1, op2, email,contact, lenguaje, disability, kindSchool,optionalNote);

						if(pdfCreator.createFicha(actualYear)) JOptionPane.showMessageDialog(null, "??Ficha de "+lastName+" "+secondLastname+" "+names+" creado exitosamente!");
						else JOptionPane.showMessageDialog(null, "Algo ocurri?? en el proceso o la carpeta destino no existe","Error",2);
						
					} catch (NumberFormatException exception) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "La edad no corresponde a un valor num??rico","Error",2);	
						logger.log(Level.WARNING,"Error al parsear la edad {0}",exception);
					}
				}
				
			}
		}
		
	}

}
