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

    public void aggiungiTavolo(TavoloDTO tavoloDTO) {
        tavolo t = new tavolo();
        t.setPosti(tavoloDTO.posti());
        t.setNumeroTAvolo(tavoloDTO.numeroTavolo());

        tavoloDao.save(t);


    }





}


