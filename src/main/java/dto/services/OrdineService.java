package dto.services;

import dao.ordineDao;
import dto.OrdineDTO;
import models.ordine;
import models.prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService
{
	@Autowired
	private ordineDao ordineDao;
	@Autowired
	private prodotto prodottiDao;

//	public OrdineDTO aggiungiOrdine(Long idOrdine)
//	{
//		ordine o = ordineDao.findByIdOrdine(idOrdine);
//		prodotto p = prodottiDao.findByIdProdotto(idOrdine);
//
//	}
}
