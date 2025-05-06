package org.example.gestaurant.dto;


import org.example.gestaurant.models.prodotto;

import java.util.List;

public record OrdineDTO(
		Long id,
		List<prodotto> prodotti,
		double totale



)
{
}
