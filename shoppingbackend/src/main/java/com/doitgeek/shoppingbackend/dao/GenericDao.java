package com.doitgeek.shoppingbackend.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	/** Persist the t object into database */
	PK create(T t);
	
	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	T find(PK id);
	List<T> findAll();
	
	/** Save changes made to a persistent object. */
	void update(T t);
	
	/** Remove an object from persistent storage in the database */
	void delete(PK id);
	void delete(T t);
}
