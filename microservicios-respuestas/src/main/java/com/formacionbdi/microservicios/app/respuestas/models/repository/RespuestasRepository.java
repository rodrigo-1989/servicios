package com.formacionbdi.microservicios.app.respuestas.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestasRepository extends CrudRepository<Respuesta, Long> {

}
