package com.formacionbdi.microservicios.app.respuestas.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
import com.formacionbdi.microservicios.app.respuestas.models.repository.RespuestasRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {

	@Autowired
	private RespuestasRepository repository;
	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return repository.saveAll(respuestas);
	}
	@Override
	@Transactional(readOnly = true)
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumniId, Long examenId) {
		return repository.findRespuestaByAlumnoByExamen(alumniId, examenId);
	}

}
