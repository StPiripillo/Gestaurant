package org.example.gestaurant.services;

import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dao.ProdottoDao;
import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.ProdottoDTO;
import org.example.gestaurant.dto.mappers.ProdottoMapper;
import org.example.gestaurant.models.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoService
{
	@Autowired
	private OrdineDao ordineDao;
	@Autowired
	private ProdottoDao prodottiDao;
	@Autowired
	private TavoloDao tavoloDao;

	public ProdottoDTO aggiungiProdotto(Long idProdotto)
	{
		Prodotto p = prodottiDao.findById(idProdotto).orElse(null);
		Prodotto pr = new Prodotto();
		pr.setId(idProdotto);
		pr.setNome(p.getNome());
		pr.setDescrizione(p.getDescrizione());
		pr.setTip(p.getTip());
		pr.setIntolleranze(p.getIntolleranze());
		pr.getPrezzo();
		pr.getQtn();

		prodottiDao.save(pr);
		return ProdottoMapper.toDto(pr);
	}
}
