package org.example.gestaurant.services;

import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dao.ProdottoDao;
import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.ProdottoDTO;
import org.example.gestaurant.dto.mappers.ProdottoMapper;
import org.example.gestaurant.models.Prodotto;
import org.example.gestaurant.models.Tavolo;
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

	public ProdottoDTO aggiungiProdotto(ProdottoDTO prodottoDTO)
	{
		Prodotto p = new Prodotto();
		p.setNome(prodottoDTO.nome());
		p.setDescrizione(prodottoDTO.descrizione());
		p.setTip(prodottoDTO.tipologia());
		p.setIntolleranze(prodottoDTO.intolleranze());
		p.setPrezzo(prodottoDTO.prezzo());
		p.setQtn(prodottoDTO.Qtn());

		prodottiDao.save(p);
		return ProdottoMapper.toDto(p);
	}

	public ProdottoDTO modificaPrezzo(Long idProdotto, double nuovoPrezzo)
	{
		Prodotto prodotto = prodottiDao.findById(idProdotto).orElseThrow(() -> new IllegalArgumentException("Prodotto non trovato"));
		prodotto.setPrezzo(nuovoPrezzo);
		prodottiDao.save(prodotto);
		return ProdottoMapper.toDto(prodotto);
	}
	public Prodotto delete(Long id)
	{
		Prodotto prodotto = prodottiDao.findById(id).orElseThrow(() -> new RuntimeException("Elemento non trovato"));
		prodottiDao.delete(prodotto);
		return prodotto;
	}

}
