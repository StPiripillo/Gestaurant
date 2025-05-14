package org.example.gestaurant.dto.mappers;

import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.OrdineDTO;
import org.example.gestaurant.dto.ProdottoDTO;
import org.example.gestaurant.models.Ordine;
import org.example.gestaurant.models.Tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdineMapper
{
    @Autowired
    private static ProdottoMapper prodottoMapper;
    @Autowired
    private static TavoloDao tavoloDao;

    public static OrdineDTO toDto(Ordine ordine)
    {

        //List<ProdottoDTO> prodottoDTOS = prodottoMapper.toDto(ordine.getProdotti());
        return new OrdineDTO(ordine.getTavolo().getId(),
                ordine.getId(),
                ordine.getTotale(),
                ordine.getNomeOrdine(),
                ordine.getNoteOrdine()
                );
    }

}



