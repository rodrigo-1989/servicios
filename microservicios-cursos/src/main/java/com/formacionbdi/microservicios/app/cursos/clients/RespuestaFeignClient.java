package com.formacionbdi.microservicios.app.cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-respuestas")
public interface RespuestaFeignClient {

	@GetMapping("/alumno/{alumnoId}/examenes-repondidos")
	public Iterable<Long> obtenerExamenesIdConRespuetaAlumno(@PathVariable Long alumnoId);
	
}
