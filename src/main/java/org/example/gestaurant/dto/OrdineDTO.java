package org.example.gestaurant.dto;


import org.example.gestaurant.models.Prodotto;

import java.util.List;

public record OrdineDTO(
		Long tavoloId,
		Long id,
		double totale,
		String nomeOrdine,
		String noteOrdine



)
{
}
