package org.example.gestaurant.dto;

import org.example.gestaurant.enums.Dimensione;
import org.example.gestaurant.enums.Forma;

public record TavoloCreateDTO(
		Long id,
		int numeroTavolo,
		Forma forma,
		Dimensione dimensione
)
{
}
