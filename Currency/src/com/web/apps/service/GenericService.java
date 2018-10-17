package com.web.apps.service;

public interface GenericService<T> {
	T find(final Object id);
	T save(T t);
}
