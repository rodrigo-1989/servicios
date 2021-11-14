package com.formacionbdi.microservicios.app.cursos.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;

@Entity
@Table(name = "cursos")
public class Curso  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Alumno> alumnos;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	} 
	
	public Curso() {
		this.alumnos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void addAlumnos(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	
	public void removeAlumnos(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3045625754878162420L;
	
}
