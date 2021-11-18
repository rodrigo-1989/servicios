package com.formacionbdi.microservicios.app.examenes.service;

import com.formacionbdi.microservicios.commons.service.CommonService;

import java.util.List;

import com.formacionbdi.microservicios.commons.examenes.Asignatura;
import com.formacionbdi.microservicios.commons.examenes.Examen;

public interface ExamenService extends CommonService<Examen>{

	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();
}
