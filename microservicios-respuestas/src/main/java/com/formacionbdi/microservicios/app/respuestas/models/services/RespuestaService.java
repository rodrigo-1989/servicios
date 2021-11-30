package com.formacionbdi.microservicios.app.respuestas.models.services;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaService {
	
	public Iterable<Respuesta> saveAll(Iterable <Respuesta> respuestas);
	
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumniId,Long examenId);
	
	public Iterable<Long> findExamenesIdsConRespuestaByAlumno(Long alumnoId);

}
