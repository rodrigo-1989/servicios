package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.models.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repositiry;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		return repositiry.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findOne(Long id) {
		return repositiry.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		return repositiry.save(alumno);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repositiry.deleteById(id);
	}

}
