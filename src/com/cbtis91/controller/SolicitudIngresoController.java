package com.cbtis91.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;

import com.cbtis91.dao.DAODiscapacidad;
import com.cbtis91.dao.DAOLengua;
import com.cbtis91.models.Discapacidad;
import com.cbtis91.models.Lengua;
import com.cbtis91.views.RegisterSolicitudIngreso;

public class SolicitudIngresoController implements ActionListener{

	private RegisterSolicitudIngreso registerSolicitudIngreso;
	private DAOLengua daoLengua;
	private DAODiscapacidad daoDiscapacidad;
	public SolicitudIngresoController(RegisterSolicitudIngreso registerSolicitudIngreso) {
		this.daoLengua= new DAOLengua();
		this.daoDiscapacidad= new DAODiscapacidad();
		this.registerSolicitudIngreso = registerSolicitudIngreso;
		loadComboBoxesResources();
	}


	@SuppressWarnings("unchecked")
	private void loadComboBoxesResources() {
		//obtiene los lenguajes, los mapea a unicamente los nombres para obtener un arreglo definido de lengujas para el comboBox
		String[] languajes=daoLengua.getAll().stream().map(Lengua::getNombreLengua).collect(Collectors.toList()).stream().toArray(String[]::new);
		
		this.registerSolicitudIngreso.comboDetails.setModel(new DefaultComboBoxModel<>(languajes));
		
		String[] discapacidades= daoDiscapacidad.getAll().stream().map(Discapacidad::getNombreDiscapacidad).collect(Collectors.toList()).toArray(String[]::new);
		
		this.registerSolicitudIngreso.comboDetailsDisability.setModel(new DefaultComboBoxModel<>(discapacidades));
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
