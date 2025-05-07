package org.example.gestaurant.controllers;

import org.example.gestaurant.dto.TavoloCreateDTO;
import org.example.gestaurant.dto.TavoloDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.gestaurant.services.TavoloService;

import java.util.List;

@RestController
@RequestMapping("/api/tavoli")
public class TavoloController {

	@Autowired
	private TavoloService tavoloService;

	@GetMapping
	public List<TavoloDTO> getAllTavoli() {
		return tavoloService.getAll();
	}

	@PostMapping()
	public void aggiungiTavolo(@RequestBody TavoloCreateDTO tavoloCreateDTO) {
		tavoloService.aggiungiTavolo(tavoloCreateDTO);
	}
}
