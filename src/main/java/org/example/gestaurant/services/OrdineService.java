package org.example.gestaurant.services;

import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dao.ProdottoDao;
import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.OrdineDTO;
import org.example.gestaurant.dto.mappers.OrdineMapper;
import org.example.gestaurant.models.Ordine;
import org.example.gestaurant.models.Tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdineService
{
	@Autowired
	private OrdineDao ordineDao;
	@Autowired
	private ProdottoDao prodottiDao;
	@Autowired
	private TavoloDao tavoloDao;

	public OrdineDTO aggiungiOrdine(OrdineDTO odto)
	{
		Tavolo t = tavoloDao.findById(odto.tavoloId()).orElseThrow(() -> new RuntimeException("Elemento non trovato"));
		Ordine or = new Ordine();
		or.setTavolo(t);
		or.setNomeOrdine(odto.nomeOrdine());
		or.setNoteOrdine(odto.noteOrdine());
		or.setTotale(odto.totale());
		ordineDao.save(or);
		return OrdineMapper.toDto(or);

	}
	public OrdineDTO getOrdineById(Long id)
	{
		Ordine ordine = ordineDao.findById(id).orElseThrow(() -> new RuntimeException("Elemento non trovato"));
		return OrdineMapper.toDto(ordine);
	}
	public List<OrdineDTO> getAll()
	{
		return ordineDao.findAll()
				.stream()
				.map(OrdineMapper::toDto)
				.collect(Collectors.toList());
	}
	//metodo per filtrare per id del Tavolo
	// da controllare
	public List<OrdineDTO> getAllByTavoloId(Long id)
	{
		return ordineDao.findAllByTavoloId(id)
				.stream()
				.map(OrdineMapper::toDto)
				.collect(Collectors.toList());
	}
	public Ordine deleteordine(Long id)
	{
		Ordine ordine = ordineDao.findById(id).orElseThrow(() -> new RuntimeException("Elemento non trovato"));
		ordineDao.delete(ordine);
		return ordine;
	}

	public void eliminaOrdiniByTavoloId(Long tavoloId) {
		if (!tavoloDao.existsById(tavoloId)) {
			throw new RuntimeException("Tavolo con ID " + tavoloId + " non trovato");
		}
		ordineDao.deleteByTavolo_Id(tavoloId);
	}
}
