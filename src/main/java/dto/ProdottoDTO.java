package dto;

import enums.intolleranze;
import enums.tipologia;
import models.ingredienti;

import java.util.List;

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
