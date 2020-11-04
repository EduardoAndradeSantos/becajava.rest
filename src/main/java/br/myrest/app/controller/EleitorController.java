package br.myrest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.myrest.app.model.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Eleitores")
public class EleitorController {

	// CRIAR - POST
	@PostMapping
	public ResponseEntity criar(@RequestBody Eleitor eleitor) {
		if (eleitor.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Eleitor não informado.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Eleitor criado com sucesso!");
	}

	// PEGA UM - GET
	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Eleitor obj = new Eleitor();
		obj.setNome("Eduardo");

		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

	// PEGA VARIOS - GET
	@GetMapping
	public ResponseEntity listar() {

		List<Eleitor> lista = new ArrayList<Eleitor>();

		Eleitor obj = new Eleitor();
		obj.setNome("Eduardo");
		lista.add(obj);

		obj = new Eleitor();
		obj.setNome("Maya");
		lista.add(obj);

		obj = new Eleitor();
		obj.setNome("Viviane");
		lista.add(obj);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	// ATUALIZA - PUT
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Eleitor eleitor, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(eleitor);
	}

	// DELETA - DELET
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}