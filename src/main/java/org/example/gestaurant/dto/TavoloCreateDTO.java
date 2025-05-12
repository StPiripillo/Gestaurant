package org.example.gestaurant.dto;

import org.example.gestaurant.enums.Forma;

public record TavoloCreateDTO(
		Long id,
		int numeroTavolo,
		int dimensione,
		Forma forma,
		int posti
)
{
}
