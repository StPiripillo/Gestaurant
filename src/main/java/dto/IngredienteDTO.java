package dto;

import enums.intolleranze;

import java.util.List;

public record IngredienteDTO(
		Long id,
		double prezzoIngrediente,
		List<intolleranze> intolleranze
)
{
}
