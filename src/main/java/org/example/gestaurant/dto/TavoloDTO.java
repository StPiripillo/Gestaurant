package org.example.gestaurant.dto;

import org.example.gestaurant.enums.Forma;

public record TavoloDTO(
		Long id,
		int numeroTavolo,
		int dimensione,
		int posti,
		Forma forma,
		boolean occupato,
		int x,
		int y
)
{
}