package org.example.gestaurant.dto;

import org.example.gestaurant.enums.intolleranze;
import org.example.gestaurant.enums.tipologia;

public record ProdottoDTO(
        Long id,
        String nome,
        String descrizione,
        tipologia tipologia,
        intolleranze intolleranze,
        double prezzo

)
{
}
