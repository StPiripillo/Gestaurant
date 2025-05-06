package org.example.gestaurant.dto;

import org.example.gestaurant.enums.Intolleranze;

public record IngredienteDTO(
		Long id,
		double prezzoIngrediente,
		Intolleranze intolleranze
)
{
}
