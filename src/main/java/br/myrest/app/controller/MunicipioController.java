package br.myrest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.myrest.app.model.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Municipios")
public class MunicipioController {

	// CRIAR - POST
	@PostMapping
	public ResponseEntity criar(@RequestBody Municipio municipio) {
		if (municipio.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Municipio não informado.");
		else if (municipio.getPopulacao() <= 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("População não informada.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Municipio criado com sucesso!");
	}

	// PEGA UM - GET
	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Municipio obj = new Municipio();
		obj.setNome("Pedrinhas");
		obj.setPopulacao(2000);

		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

	// PEGA VARIOS - GET
	@GetMapping
	public ResponseEntity listar() {

		List<Municipio> lista = new ArrayList<Municipio>();

		Municipio obj = new Municipio();
		obj.setNome("Pedrinhas");
		obj.setPopulacao(2000);
		lista.add(obj);

		obj = new Municipio();
		obj.setNome("Guarulhos");
		obj.setPopulacao(28988);
		lista.add(obj);

		obj = new Municipio();
		obj.setNome("Guapapa");
		obj.setPopulacao(344456);
		lista.add(obj);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	// ATUALIZA - PUT
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Municipio municipio, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(municipio);
	}

	// DELETA - DELET
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
