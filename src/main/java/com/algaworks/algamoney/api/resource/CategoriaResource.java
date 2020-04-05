package com.algaworks.algamoney.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoney.api.AlgamoneyApiApplication;
import com.algaworks.algamoney.api.event.RecursoCriadoEvent;
import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import com.algaworks.algamoney.api.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	private static Logger logger = LogManager.getLogger(AlgamoneyApiApplication.class);

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public List<Categoria> listar() {
		logger.info("ALGAMONEY-API: GET Categoria: HTTP_STATUS_CODE: " + ResponseEntity.ok().toString());
		return categoriaRepository.findAll();
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		logger.info("ALGAMONEY-API: POST Categoria: HTTP_STATUS_CODE:[" + response.getStatus()+"]");		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
		 Categoria categoria = categoriaRepository.findOne(codigo);
		 if (categoria == null) {
			 logger.warn("ALGAMONEY-API: GET Categoria:[" + codigo + "]: HTTP_STATUS_CODE:["+ ResponseEntity.status(HttpStatus.NOT_FOUND)+"]");		
			 return ResponseEntity.notFound().build();
		 }
		 logger.info("ALGAMONEY-API: GET Categoria:[" + codigo + "]: HTTP_STATUS_CODE:[" + ResponseEntity.status(HttpStatus.OK)+"]");	
		 return ResponseEntity.ok(categoria);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CATEGORIA') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		logger.info("ALGAMONEY-API: DEL Categoria:[" + codigo + "]: HTTP_STATUS_CODE:[" + ResponseEntity.status(HttpStatus.NO_CONTENT)+"]");	
		categoriaRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaService.atualizar(codigo, categoria);
  	    logger.info("ALGAMONEY-API: PUT Categoria:[" + codigo + "]: HTTP_STATUS_CODE:[" + ResponseEntity.status(HttpStatus.OK)+"]");	
		return ResponseEntity.ok(categoriaSalva);
	}
}
