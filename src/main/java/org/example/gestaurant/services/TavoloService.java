package org.example.gestaurant.services;

import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dao.ProdottoDao;
import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.TavoloCreateDTO;
import org.example.gestaurant.dto.TavoloDTO;
import org.example.gestaurant.models.Tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TavoloService {

    @Autowired
    private TavoloDao tavoloDao;
    @Autowired
    private OrdineDao ordineDao;
    @Autowired
    private ProdottoDao prodottiDao;

    public void aggiungiTavolo(TavoloCreateDTO tavoloCreateDTO) {
        Tavolo t = new Tavolo();
        t.setPosti(tavoloCreateDTO.posti());
        t.setNumeroTAvolo(tavoloCreateDTO.numeroTAvolo());

        tavoloDao.save(t);


    }
    public List<TavoloDTO> getAll() {
        return tavoloDao.findAll()
                .stream()
                .map(t -> new TavoloDTO(
                        t.getId(),
                        t.getNumeroTAvolo(),
                        t.getPosti(),
                        t.isOccupato()
                ))
                .collect(Collectors.toList());
    }






}


