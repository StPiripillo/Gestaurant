package dto;


import models.prodotto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record OrdineDTO(
		Long id,
		List<prodotto> prodotti,
		double totale



)
{
}
