package org.example.gestaurant.controllers;

import org.example.gestaurant.dao.IngredientiDao;
import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.OrdineDTO;
import org.example.gestaurant.dto.ProdottoDTO;
import org.example.gestaurant.enums.Tipologia;
import org.example.gestaurant.models.Ingredienti;
import org.example.gestaurant.models.Ordine;
import org.example.gestaurant.models.Prodotto;
import org.example.gestaurant.services.OrdineService;
import org.example.gestaurant.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {

	@Autowired
	private OrdineService ordineService;
	@Autowired
	private ProdottoService prodottoService;
	@Autowired
	private IngredientiDao ingredientiDAO;
	@Autowired
	private TavoloDao tavoloDao;
//	@Autowired
//	private OrdineDao ordineDao;


	@GetMapping()
	public List<OrdineDTO> getAll()
	{
		return ordineService.getAll();

	}

	@GetMapping("/{ordineId}")
	public OrdineDTO getOrdineById(@PathVariable Long ordineId) {
		return ordineService.getOrdineById(ordineId);
	}

	//da controllare
	@PostMapping("/newordine")
	public OrdineDTO aggiungi(@RequestBody OrdineDTO ordineDTO)
	{
		 return ordineService.aggiungiOrdine(ordineDTO);
	}
	//fare metodo getAll prodotti
	@GetMapping("/prodotti")
	public List<ProdottoDTO> getAllProdotti() {
		return prodottoService.getAllProdotti();
	}
	//metodo per creare i prodotti

	@PostMapping ("/newprodotto")
	public ProdottoDTO aggiungiProdotto(@RequestBody ProdottoDTO prodottoDTO){
		return prodottoService.aggiungiProdotto(prodottoDTO);
	}

	//c
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminaProdotto(@PathVariable Long id) {
		Prodotto prodotto = prodottoService.delete(id);
		if (prodotto != null) {
			return ResponseEntity.ok(prodotto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	@PostMapping("/ingredienti")
	public ResponseEntity<Ingredienti> creaIngrediente(@RequestBody Ingredienti ingrediente) {
		Ingredienti salvato = ingredientiDAO.save(ingrediente);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvato);
	}

	@GetMapping("/ingredienti")
	public List<Ingredienti> getAllIngredienti() {
		return ingredientiDAO.findAll();
	}

	@GetMapping("/ingredienti/{id}")
	public ResponseEntity<Ingredienti> getIngredienteById(@PathVariable Long id) {
		return ingredientiDAO.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/ingredienti/{id}")
	public ResponseEntity<Ingredienti> aggiornaIngrediente(
			@PathVariable Long id,
			@RequestBody Ingredienti nuovoIngrediente) {

		return ingredientiDAO.findById(id).map(ingrediente -> {
			ingrediente.setNome(nuovoIngrediente.getNome());
			ingrediente.setPrezzoIngredienti(nuovoIngrediente.getPrezzoIngredienti());
			ingrediente.setIntolleranze(nuovoIngrediente.getIntolleranze());
			Ingredienti aggiornato = ingredientiDAO.save(ingrediente);
			return ResponseEntity.ok(aggiornato);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/ingredienti/{id}")
	public ResponseEntity<Void> eliminaIngrediente(@PathVariable Long id) {
		if (!ingredientiDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		ingredientiDAO.deleteById(id);
		return ResponseEntity.noContent().build();
	}
//	@PostMapping("/{tavoloId}/prezzo")
//	public ProdottoDTO modificaPrezzo(@RequestBody ProdottoDTO prodottoDTO, @PathVariable Long tavoloId)
//	{
//		return prodottoService.modificaPrezzo(prodottoDTO.tavoloId(), tavoloId);
//	}
	@PostMapping("/{id}/prezzo")
	public ProdottoDTO modificaPrezzo(@PathVariable Long id, @RequestBody Map<String, Double> prezzo)
	{
		double prezzoProdotto = prezzo.get("prezzo");
		return prodottoService.modificaPrezzo(id, prezzoProdotto);
	}


	@GetMapping("/categoria")
	public List<String> getCategoria() {
		return Arrays.stream(Tipologia.values())
				.map(Tipologia::name)
				.collect(Collectors.toList());
	}
	@GetMapping("/bytavolo")
	public List<OrdineDTO> getOrdiniByTavolo(@PathVariable Long tavoloId) {
		return ordineService.getAllByTavoloId(tavoloId);
	}
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Void> cancellaOrdine(@PathVariable Long id) {
		Ordine ordine = ordineService.deleteordine(id);
		if (ordine != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}







}
