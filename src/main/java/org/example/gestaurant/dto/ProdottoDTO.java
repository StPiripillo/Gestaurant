package org.example.gestaurant.dto;

import org.example.gestaurant.enums.Intolleranze;
import org.example.gestaurant.enums.Tipologia;

public record ProdottoDTO(
		Long id,
        String nome,
        String descrizione,
        Tipologia tipologia,
        Intolleranze intolleranze,
        double prezzo,
		int Qtn

)
{
}
