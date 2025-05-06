package dto.services;

import dao.ordineDao;
import dao.prodottoDao;
import dao.tavoloDao;
import dto.OrdineDTO;
import dto.mappers.OrdineMapper;
import models.ordine;
import models.prodotto;
import models.tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
		ordine o = ordineDao.findByIdOrdine(idOrdine);
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
