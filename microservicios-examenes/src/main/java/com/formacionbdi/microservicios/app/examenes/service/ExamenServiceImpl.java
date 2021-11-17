package com.formacionbdi.microservicios.app.examenes.service;

import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.examenes.models.repository.ExamenRepository;
import com.formacionbdi.microservicios.commons.service.CommonServiceImpl;
import com.formacionbdi.microservicios.commons.examenes.Examen;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {


}
