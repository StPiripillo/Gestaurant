package dto.mappers;

import dto.OrdineDTO;
import dto.ProdottoDTO;
import models.ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineMapper
{
    @Autowired
    private static ProdottoMapper prodottoMapper;

    public static OrdineDTO toDto(ordine ordine)
    {
        List<ProdottoDTO> prodottoDTOS = prodottoMapper.toDto(ordine.getProdotti());
        return new OrdineDTO(ordine.getId(), ordine.getProdotti(), ordine.getTotale());
    }

}



