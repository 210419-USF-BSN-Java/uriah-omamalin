package com.shop.daos;

public interface GenericDAO<T, PK> {
	PK create(T newEntry);
	T read(PK primaryKey);
	void update(PK primaryKey);
	void delete(PK primaryKey);
}