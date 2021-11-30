package com.formacionbdi.microservicios.app.cursos.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.cursos.clients.RespuestaFeignClient;
import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.models.repository.CursoRepository;
import com.formacionbdi.microservicios.commons.service.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {
	
	@Autowired
	private RespuestaFeignClient cliente;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findByAlumnoId(Long id) {
		return repositiry.findByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdConRespuetaAlumno(Long alumnoId) {
		return cliente.obtenerExamenesIdConRespuetaAlumno(alumnoId);
	}

}
