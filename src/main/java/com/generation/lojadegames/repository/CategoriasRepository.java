package com.generation.lojadegames.repository;

	import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.lojadegames.model.Categorias;

	@Repository
	public interface CategoriasRepository extends JpaRepository < Categorias , Long> {
		
		public List <Categorias> findAllByTipoContainingIgnoreCase (@Param ("tipo") String tipo);


	}


