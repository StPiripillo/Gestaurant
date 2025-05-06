package org.example.gestaurant.services;

import org.example.gestaurant.dao.ordineDao;
import org.example.gestaurant.dao.prodottoDao;
import org.example.gestaurant.dao.tavoloDao;
import org.example.gestaurant.dto.TavoloDTO;
import org.example.gestaurant.models.tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TavoloService {

    @Autowired
    private tavoloDao tavoloDao;
    @Autowired
    private ordineDao ordineDao;
    @Autowired
    private prodottoDao prodottiDao;

    public void aggiungiTavolo(TavoloDTO tavoloDTO) {
        tavolo t = new tavolo();
        t.setPosti(tavoloDTO.posti());
        t.setNumeroTAvolo(tavoloDTO.numeroTavolo());

        tavoloDao.save(t);


    }
    public List<TavoloDTO> getAll() {
        return tavoloDao.findAll()
                .stream()
                .map(t -> new TavoloDTO(
                        t.getId(),
                        t.getNumeroTAvolo(),
                        t.getPosti(),
                        t.isOccupato() ? "OCCUPATO" : "LIBERO"
                ))
                .collect(Collectors.toList());
    }






}


