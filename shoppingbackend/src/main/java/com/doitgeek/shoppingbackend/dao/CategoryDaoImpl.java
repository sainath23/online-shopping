package com.doitgeek.shoppingbackend.dao;

import org.springframework.stereotype.Repository;

import com.doitgeek.shoppingbackend.entity.Category;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category, Long> implements CategoryDao {

}
