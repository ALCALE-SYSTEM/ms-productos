package com.alcale.solutions.msproductos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alcale.solutions.msproductos.entity.Producto;
import com.alcale.solutions.msproductos.service.IProductoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("servicio-productos")
public class ProductoController {

	private final IProductoService productoService; 
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping
	@ResponseBody
	ResponseEntity<List<Producto>> findAll(){
		List<Producto> products = productoService.findAll()
				.stream()
				.map(product -> {
					product.setPort(port);
					return product;
				}).collect(Collectors.toList());
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Producto> findById(@PathVariable Long id){
		Producto product = productoService.findById(id);
		product.setPort(port);
		return ResponseEntity.ok(product);
	}
}
