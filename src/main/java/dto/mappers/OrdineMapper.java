package dto.mappers;

import dto.OrdineDTO;
import dto.ProdottoDTO;
import models.ordine;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrdineMapper
{
	@Autowired
	ProdottoMapper prodottoMapper;

	public OrdineDTO toDto(ordine ordine)
	{
		List<ProdottoDTO> prodottoDTOS = prodottoMapper.toDtos(ordine.getProdotti());
		return new OrdineDTO(ordine.getId(), ordine.getProdotti(), ordine.getTotale());
	}
}
