/*package com.doitgeek.shoppingbackend.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	
	protected EntityManager entityManager;
	protected Class<T> entityClass;
	
	public GenericDaoImpl(Class<T> entityClass, EntityManager entityManager) {
		this.entityClass = entityClass;
		this.entityManager = entityManager;
	}

	@Override
	public T save(T t) {
		this.entityManager.persist(t);
		return t;
	}

	@Override
	public T find(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T update(T t) {
		return this.entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		entityManager.remove(t);
	}

}*/
