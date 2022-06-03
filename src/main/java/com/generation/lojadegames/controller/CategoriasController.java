package com.generation.lojadegames.controller;

	import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojadegames.model.Categorias;
import com.generation.lojadegames.repository.CategoriasRepository;

	@RestController
	@RequestMapping("/categorias")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class CategoriasController {
		
		@Autowired
		private CategoriasRepository categoriasRepository;

		@GetMapping
		public ResponseEntity<List<Categorias>> getAll(){
			
			return ResponseEntity.ok(categoriasRepository.findAll());
		 }
		@GetMapping("/{id}")
		public ResponseEntity<Categorias> getById(@PathVariable Long id){
			return categoriasRepository.findById(id)
			  .map(resposta ->ResponseEntity.ok(resposta))
			  .orElse(ResponseEntity.notFound().build());
		}
		@GetMapping("/categorias/{categorias}")
		public ResponseEntity<List<Categorias>> getByTipo(@PathVariable String tipo){
			
			return ResponseEntity.ok(categoriasRepository.findAllByTipoContainingIgnoreCase(tipo));
		}
		@PostMapping
		public ResponseEntity <Categorias> postCategorias (@Valid @RequestBody Categorias categorias){
			
			return ResponseEntity.status( HttpStatus.CREATED).body(categoriasRepository.save(categorias));
		}
		@PutMapping
		public ResponseEntity <Categorias> putCategorias(@Valid @RequestBody Categorias categorias){
			
			if (categorias.getId() == null)
				return ResponseEntity.badRequest().build();
			
			return categoriasRepository.findById(categorias.getId())
					  .map(resposta ->ResponseEntity.status(HttpStatus.OK).body(categoriasRepository.save(categorias)))
					  .orElse(ResponseEntity.notFound().build());
			
		}
		@DeleteMapping("/{id}")
		public ResponseEntity <Categorias> deleteCategorias(@PathVariable Long id) {
			 
			 if (categoriasRepository.existsById(id)) {
				 categoriasRepository.deleteById(id);
			 
				 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			 }
				 
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 

		}


	}


