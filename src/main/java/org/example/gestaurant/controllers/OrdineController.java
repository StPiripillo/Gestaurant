package org.example.gestaurant.controllers;

import org.example.gestaurant.dao.ordineDao;
import org.example.gestaurant.dto.OrdineDTO;
import org.example.gestaurant.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {
	@Autowired
	private OrdineService ordineService;

	@Autowired
	private ordineDao oDao;

	@GetMapping
	public List<OrdineDTO> getAll() {

		return oDao.findAll().stream().map(ordine -> new OrdineDTO(
						ordine.getId(),
						ordine.getProdotti(),
						ordine.getTotale()
				))
				.collect(Collectors.toList());

	}


}
