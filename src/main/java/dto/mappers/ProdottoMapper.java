package dto.mappers;

import dto.ProdottoDTO;
import models.prodotto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoMapper {

    public static ProdottoDTO toDto(prodotto prodotto) {
        return new ProdottoDTO(
                prodotto.getId(), prodotto.getNome(), prodotto.getDescrizione(),prodotto.getTip(),prodotto.getIntolleranze(), prodotto.getPrezzo());

    }
public List<ProdottoDTO> toDto(List<prodotto> prodotti) {
        return prodotti.stream().map(prodotto -> toDto(prodotto)).toList();
}

}

