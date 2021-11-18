package com.formacionbdi.microservicios.commons.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonServiceImpl<E,R extends PagingAndSortingRepository<E,Long>> implements CommonService<E> {

	@Autowired
	protected R repositiry;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		return repositiry.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {
		return repositiry.findById(id);
	}

	@Override
	@Transactional
	public E save(E entity) {
		return repositiry.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repositiry.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) {
		return repositiry.findAll(pageable);
	}

}
