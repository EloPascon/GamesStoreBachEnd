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

import com.generation.lojadegames.model.Produtos;
import com.generation.lojadegames.repository.ProdutosRepository;

	@RestController
	@RequestMapping("/produtos")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class ProdutosController {
		
		@Autowired
		private ProdutosRepository produtosRepository;
		

	@GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		
		return ResponseEntity.ok(produtosRepository.findAll());
	 }
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable Long id){
		return produtosRepository.findById(id)
		  .map(resposta ->ResponseEntity.ok(resposta))
		  .orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> getByDescricao(@PathVariable String Descricao){
		
		return ResponseEntity.ok(produtosRepository.findAllByDescricaoContainingIgnoreCase(Descricao));
	}
	@PostMapping
	public ResponseEntity <Produtos> postProdutos (@Valid @RequestBody Produtos produtos){
		
		return ResponseEntity.status( HttpStatus.CREATED).body(produtosRepository.save(produtos));
	}
	@PutMapping
	public ResponseEntity <Produtos> putProdutos(@Valid @RequestBody Produtos produtos){
		
		if (produtos.getId() == null)
			return ResponseEntity.badRequest().build();
		
		return produtosRepository.findById(produtos.getId())
				  .map(resposta ->ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produtos)))
				  .orElse(ResponseEntity.notFound().build());
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity <Produtos> deleteProdutos(@PathVariable Long id) {
		 
		 if (produtosRepository.existsById(id)) {
			 produtosRepository.deleteById(id);
		 
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		 }
			 
	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 

	}

}
	
