package org.example.gestaurant.dto;

public record TavoloDTO(
		Long id,
		int numeroTavolo,
		int posti,
		boolean occupato,
		int x,
		int y
)
{
}