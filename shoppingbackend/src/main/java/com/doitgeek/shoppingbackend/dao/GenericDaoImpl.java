package com.doitgeek.shoppingbackend.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	
	private Class<T> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = false)
	public PK create(T t) {
		return (PK) getSession().save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public T find(PK id) {
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return (List<T>) getSession().createQuery("FROM " + entityClass.getName()).list();
	}

	@Override
	@Transactional(readOnly = false)
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(PK id) {
		T t = getSession().load(entityClass, id);
		getSession().delete(t);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(T t) {
		getSession().delete(t);
	}
}
