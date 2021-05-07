package com.revature.daos;

import java.util.List;

public interface GenericDAO<T, PK> {
	void create(T t);
	T readOne(PK pk);
	List<T> readAll();
	void update(T t);
	void deleteByObject(T t);
	void deleteById(PK pk);
}