package org.example.gestaurant.dto;


import org.example.gestaurant.models.Prodotto;

import java.util.List;

public record OrdineDTO(
		Long id,
		List<Prodotto> prodotti,
		double totale



)
{
}
