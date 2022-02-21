package com.cbtis91.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.cbtis91.dao.DAODiscapacidad;
import com.cbtis91.dao.DAOEspecialidad;
import com.cbtis91.dao.DAOLengua;
import com.cbtis91.models.Discapacidad;
import com.cbtis91.models.Especialidad;
import com.cbtis91.models.Lengua;
import com.cbtis91.views.RegisterSolicitudIngreso;

public class SolicitudIngresoController implements ActionListener{

	private RegisterSolicitudIngreso registerSolicitudIngreso;
	private DAOLengua daoLengua;
	private DAODiscapacidad daoDiscapacidad;
	private DAOEspecialidad daoEspecialidad;
	/**
	 * @wbp.parser.entryPoint
	 */
	public SolicitudIngresoController(RegisterSolicitudIngreso registerSolicitudIngreso) {
		this.daoLengua= new DAOLengua();
		this.daoDiscapacidad= new DAODiscapacidad();
		this.daoEspecialidad= new DAOEspecialidad();
		this.registerSolicitudIngreso = registerSolicitudIngreso;
		loadComboBoxesResources();
		loadListerners();
	}


	private void loadListerners() {
		this.registerSolicitudIngreso.btnRegister.addActionListener(this);
		onlyNumbersTextField();
	}


	private void onlyNumbersTextField() {
		this.registerSolicitudIngreso.txtAge.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				//super.keyTyped(e);
				try {
					Integer.parseInt(String.format("%c", e.getKeyChar())); //solo es para detectar si hay un valor no numérico, en caso de que si, la tecla presionada no es mostrada en el campo
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
					Integer.parseInt(String.format("%c", e.getKeyChar())); //solo es para detectar si hay un valor no numérico, en caso de que si, la tecla presionada no es mostrada en el campo
				} catch (NumberFormatException ex2) {
					e.setKeyChar('\0');
				}
			}
		
		});
		//cuando el foco sale, verificar si es una extensión de 10 digitos el numero de telefono
		this.registerSolicitudIngreso.txtContact.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				JTextField field=(JTextField) e.getSource();
				if(field.getText().length()!=10) {
					JOptionPane.showMessageDialog(null, "El número de contacto debe ser 10 dígitos");
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
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.registerSolicitudIngreso.btnRegister) {
			if(JOptionPane.showConfirmDialog(null, "Confirmación de generación de ficha")==0) {
				
			}
		}
		
	}

}
