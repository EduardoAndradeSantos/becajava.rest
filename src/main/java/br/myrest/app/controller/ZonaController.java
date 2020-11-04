package br.myrest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.myrest.app.model.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Zonas")
public class ZonaController {

	// CRIAR - POST
	@PostMapping
	public ResponseEntity criar(@RequestBody Zona zona) {
		if (zona.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Zona não informada.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Zona criada com sucesso!");
	}

	// PEGA UM - GET
	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Zona obj = new Zona();
		obj.setNome("Escolinha do barulho");

		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

	// PEGA VARIOS - GET
	@GetMapping
	public ResponseEntity listar() {

		List<Zona> lista = new ArrayList<Zona>();

		Zona obj = new Zona();
		obj.setNome("Escolinha do barulho");
		lista.add(obj);

		obj = new Zona();
		obj.setNome("Faculdade socio");
		lista.add(obj);

		obj = new Zona();
		obj.setNome("Escola estadual");
		lista.add(obj);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	// ATUALIZA - PUT
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Zona zona, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(zona);
	}

	// DELETA - DELET
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
