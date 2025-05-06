package dto;


import models.prodotto;

import java.util.List;

public record OrdineDTO(
		Long id,
		List<prodotto> prodotti,
		double totale
)
{
}
