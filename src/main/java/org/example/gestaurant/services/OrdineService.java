package org.example.gestaurant.services;

import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dao.ProdottoDao;
import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.OrdineDTO;
import org.example.gestaurant.dto.mappers.OrdineMapper;
import org.example.gestaurant.models.Ordine;
import org.example.gestaurant.models.Prodotto;
import org.example.gestaurant.models.Tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class OrdineService
{
	@Autowired
	private OrdineDao ordineDao;
	@Autowired
	private ProdottoDao prodottiDao;
	@Autowired
	private TavoloDao tavoloDao;

	public OrdineDTO aggiungiOrdine(Long idOrdine, Long idProdotto)
	{
		Ordine o= ordineDao.findById(idOrdine).orElse(null);
		Prodotto p = prodottiDao.findById(idProdotto).orElse(null);
		Tavolo t = tavoloDao.findById(idOrdine).orElse(null);

		Ordine or = new Ordine();
		or.setId(idOrdine);
		or.setProdotti((List<Prodotto>) p);
		or.setOra(LocalTime.now());
		or.setTavolo(t);

		ordineDao.save(or);
		return OrdineMapper.toDto(or);

	}
}
