package org.example.gestaurant.controllers;

import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dto.OrdineDTO;
import org.example.gestaurant.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {
	@Autowired
	private OrdineService ordineService;

	@Autowired
	private OrdineDao oDao;

	@GetMapping
	public List<OrdineDTO> getAll() {

		return oDao.findAll().stream().map(ordine -> new OrdineDTO(
						ordine.getId(),
						ordine.getProdotti(),
						ordine.getTotale()
				))
				.collect(Collectors.toList());

	}

	//da controllare
	@PostMapping
	public OrdineDTO aggiungi(@RequestBody OrdineDTO ordineDTO)
	{
		 return ordineService.aggiungiOrdine(ordineDTO.id(), ordineDTO.id());
	}


}
