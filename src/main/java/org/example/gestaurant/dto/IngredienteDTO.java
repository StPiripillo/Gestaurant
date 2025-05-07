package org.example.gestaurant.dto;

import org.example.gestaurant.enums.Intolleranze;

public record IngredienteDTO(
		double prezzoIngrediente,
		Intolleranze intolleranze
)
{
}
