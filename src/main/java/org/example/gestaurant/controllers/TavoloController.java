package org.example.gestaurant.controllers;

import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.TavoloCreateDTO;
import org.example.gestaurant.dto.TavoloDTO;
import org.example.gestaurant.models.Tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.gestaurant.services.TavoloService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tavoli")
@CrossOrigin(origins = "http://localhost:4200")
public class TavoloController {

	@Autowired
	private TavoloService tavoloService;
	@Autowired
	private TavoloDao tavoloDao;

	public TavoloController(TavoloService service) {
		this.tavoloService = service;
	}

	@GetMapping
	public List<TavoloDTO> getAllTavoli() {
		return tavoloService.getAll();
	}

	@PostMapping()
	public void aggiungiTavolo(@RequestBody TavoloDTO tavoloDTO) {
		tavoloService.aggiungiTavolo(tavoloDTO);
	}

	@PutMapping("/{id}")
	public Tavolo updatePosition(@PathVariable Long id, @RequestBody TavoloDTO tav) {
		int x = tav.x();
		int y = tav.y();

		return tavoloService.updatePosition(id, x, y);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Tavolo tavolo = tavoloDao.findById(id).orElse(null);
		if (tavolo != null) {
			tavoloDao.delete(tavolo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping ("/{id}/numero")
	public Tavolo updateNumeroTavolo( @PathVariable Long id,@RequestBody Map<String, Integer> body)
	{
		int numeroTavolo = body.get("numeroTavolo");
		return tavoloService.updateNumeroTavolo(id, numeroTavolo);
	}

	@PutMapping("/{id}/occupato")
	private Tavolo updateOccupato(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
		boolean occupato = body.get("occupato");
		return tavoloService.updateOccupato(id, occupato);
	}

}
