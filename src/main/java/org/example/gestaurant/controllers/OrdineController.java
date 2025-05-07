package org.example.gestaurant.controllers;

import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dao.ProdottoDao;
import org.example.gestaurant.dto.OrdineDTO;
import org.example.gestaurant.dto.ProdottoDTO;
import org.example.gestaurant.services.OrdineService;
import org.example.gestaurant.services.ProdottoService;
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

	@Autowired
	private ProdottoDao pDao;
	@Autowired
	private ProdottoService prodottoService;


	@GetMapping
	public List<OrdineDTO> getAll()
	{

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
	//fare metodo getAll prodotti
	@GetMapping
	public List<ProdottoDTO> getAllProdotti() {
		return pDao.findAll().stream()
				.map(prodotto -> new ProdottoDTO(
						prodotto.getId(),
						prodotto.getNome(),
						prodotto.getDescrizione(),
						prodotto.getTip(),
						prodotto.getIntolleranze(),
						prodotto.getPrezzo(),
						prodotto.getQtn()
				))
				.collect(Collectors.toList());
	}
	//metodo per creare i prodotti

	@PostMapping ("/newprodotto")
	public ProdottoDTO aggiungiProdotto(@RequestBody ProdottoDTO prodottoDTO){
		return prodottoService.aggiungiProdotto(prodottoDTO.id());
	}


	@DeleteMapping("/{id}")
	public void eliminaProdotto(@PathVariable Long id) {
		pDao.deleteById(id);
	}

	@PostMapping("/{id}/prezzo")
	public ProdottoDTO modificaPrezzo(@RequestBody ProdottoDTO prodottoDTO, @PathVariable Long id)
	{
		return prodottoService.modificaPrezzo(prodottoDTO.id(), id);
	}



}
