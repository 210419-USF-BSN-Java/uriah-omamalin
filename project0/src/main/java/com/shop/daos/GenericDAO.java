package com.shop.daos;

public interface GenericDAO<T, PK> {
	PK create(T newEntry);
	T read(PK primaryKey);
	int delete(PK primaryKey);
}