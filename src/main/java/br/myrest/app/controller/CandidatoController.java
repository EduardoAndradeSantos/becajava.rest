package br.myrest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.myrest.app.model.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Candidatos")
public class CandidatoController {

	// CRIAR - POST
	@PostMapping
	public ResponseEntity criar(@RequestBody Candidato candidato) {
		if (candidato.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Candidato não informado.");
		else if (candidato.getNumero() <= 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Numero de candidato não informado.");
		else if (candidato.getTipo() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de candidato não informado.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Candidato criado com sucesso!");
	}

	// PEGA UM - GET
	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Candidato obj = new Candidato();
		obj.setNome("Paulinho da viola");
		obj.setNumero(23);
		obj.setTipo("Vereador");

		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

	// PEGA VARIOS - GET
	@GetMapping
	public ResponseEntity listar() {

		List<Candidato> lista = new ArrayList<Candidato>();

		Candidato obj = new Candidato();
		obj.setNome("Paulinho da viola");
		obj.setNumero(23);
		obj.setTipo("Vereador");
		lista.add(obj);

		obj = new Candidato();
		obj.setNome("Toninho pipoqueiro");
		obj.setNumero(45);
		obj.setTipo("Vereador");
		lista.add(obj);

		obj = new Candidato();
		obj.setNome("Vanessa do gas");
		obj.setNumero(56);
		obj.setTipo("Vereador");
		lista.add(obj);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	// ATUALIZA - PUT
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Candidato candidato, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(candidato);
	}

	// DELETA - DELET
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
