package org.example.gestaurant.dto;

import org.example.gestaurant.enums.intolleranze;

public record IngredienteDTO(
		Long id,
		double prezzoIngrediente,
		intolleranze intolleranze
)
{
}
