package com.alcale.solutions.msproductos.service;

import java.util.List;

import com.alcale.solutions.msproductos.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
}
