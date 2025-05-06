package org.example.gestaurant.dto.mappers;

import org.example.gestaurant.dto.ProdottoDTO;
import org.example.gestaurant.models.Prodotto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoMapper {

    public static ProdottoDTO toDto(Prodotto prodotto) {
        return new ProdottoDTO(
                prodotto.getId(), prodotto.getNome(), prodotto.getDescrizione(),prodotto.getTip(),prodotto.getIntolleranze(), prodotto.getPrezzo());

    }
public List<ProdottoDTO> toDto(List<Prodotto> prodotti) {
        return prodotti.stream().map(prodotto -> toDto(prodotto)).toList();
}

}

