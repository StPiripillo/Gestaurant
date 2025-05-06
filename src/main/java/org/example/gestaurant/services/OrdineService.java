package org.example.gestaurant.services;

import org.example.gestaurant.dao.ordineDao;
import org.example.gestaurant.dao.prodottoDao;
import org.example.gestaurant.dao.tavoloDao;
import org.example.gestaurant.dto.OrdineDTO;
import org.example.gestaurant.dto.mappers.OrdineMapper;
import org.example.gestaurant.models.ordine;
import org.example.gestaurant.models.prodotto;
import org.example.gestaurant.models.tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class OrdineService
{
	@Autowired
	private ordineDao ordineDao;
	@Autowired
	private prodottoDao prodottiDao;
	@Autowired
	private tavoloDao tavoloDao;

	public OrdineDTO aggiungiOrdine(Long idOrdine, Long idProdotto)
	{
		ordine o= ordineDao.findById(idOrdine).orElse(null);
		prodotto p = prodottiDao.findById(idProdotto).orElse(null);
		tavolo t = tavoloDao.findById(idOrdine).orElse(null);

		ordine or = new ordine();
		or.setId(idOrdine);
		or.setProdotti((List<prodotto>) p);
		or.setOra(LocalTime.now());
		or.setTavolo(t);

		ordineDao.save(or);
		return OrdineMapper.toDto(or);

	}
}
