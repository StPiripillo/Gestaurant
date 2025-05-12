package org.example.gestaurant.dto;

import org.example.gestaurant.enums.Dimensione;
import org.example.gestaurant.enums.Forma;

public record TavoloDTO(
		Long id,
		int numeroTavolo,
//		Forma forma,
//		Dimensione dimensione,
		int posti,
		int occupato,
		int x,
		int y
)
{
}