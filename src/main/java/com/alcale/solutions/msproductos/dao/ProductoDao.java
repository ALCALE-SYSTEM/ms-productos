package com.alcale.solutions.msproductos.dao;

import org.springframework.data.repository.CrudRepository;

import com.alcale.solutions.msproductos.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
