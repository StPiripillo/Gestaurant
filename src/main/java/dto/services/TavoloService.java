package services;

import dao.ordineDao;
import dao.prodottoDao;
import dao.tavoloDao;
import dto.TavoloDTO;
import jakarta.persistence.Id;
import models.ordine;
import models.prodotto;
import models.tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalTime;
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

    public TavoloDTO aggiungiTavolo(Long idTavolo,Long idOrdine, Long idProdotto) {
        tavolo t= tavoloDao.findByIdTavolo(idTavolo);
        ordine o= ordineDao.findByIdOrdine(idOrdine);
        prodotto p= prodottiDao.findByIProdotto(idProdotto);

        tavolo tavol= new tavolo();
        tavol.setId(idTavolo);
        tavol.setPosti(tavol.getPosti());
        tavol.setNumeroTAvolo(tavol.getNumeroTAvolo());

        tavoloDao.save(idTavolo);
        return new TavoloDTO(tavol.getId(),tavol.getPosti(),tavol.getNumeroTAvolo(),tavol.toString());


    }





}


