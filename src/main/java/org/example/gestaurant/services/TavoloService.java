package org.example.gestaurant.services;

import org.example.gestaurant.dao.OrdineDao;
import org.example.gestaurant.dao.ProdottoDao;
import org.example.gestaurant.dao.TavoloDao;
import org.example.gestaurant.dto.TavoloDTO;
import org.example.gestaurant.models.Tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TavoloService {

    @Autowired
    private TavoloDao tavoloDao;
    @Autowired
    private OrdineDao ordineDao;
    @Autowired
    private ProdottoDao prodottiDao;

    public TavoloService(TavoloDao tavoloDao)
    {
        this.tavoloDao = tavoloDao;
    }

    public void aggiungiTavolo(TavoloDTO tavoloDTO) {
        Tavolo t = new Tavolo();
        t.setNumeroTavolo(tavoloDTO.numeroTavolo());
        t.setForma(tavoloDTO.forma());
        t.setDimensione(tavoloDTO.dimensione());
        t.setPosti(tavoloDTO.posti());

        tavoloDao.save(t);
    }
    public List<TavoloDTO> getAll() {
        return tavoloDao.findAll()
                .stream()
                .map(t -> new TavoloDTO(
                        t.getId(),
                        t.getNumeroTavolo(),
                        t.getForma(),
                        t.getDimensione(),
                        t.getPosti(),
                        t.getOccupato(),
                        t.getX(),
                        t.getY(),
                        t.getXBackup(),
                        t.getYBackup()
                ))
                .collect(Collectors.toList());
    }

    public Tavolo updatePosition(Long id, int x, int y) {
        Tavolo tavolo = tavoloDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Elemento non trovato"));
        tavolo.setX(x);
        tavolo.setY(y);
        return tavoloDao.save(tavolo);
    }

    public Tavolo delete(Long id)
    {
        Tavolo tavolo = tavoloDao.findById(id).orElseThrow(() -> new RuntimeException("Elemento non trovato"));
        tavoloDao.delete(tavolo);
        return tavolo;
    }
    public Tavolo updateNumeroTavolo(Long id, int nuovoNumero) {
        Tavolo tavolo = tavoloDao.findById(id).orElseThrow(() -> new RuntimeException("Tavolo non trovato"));
        tavolo.setNumeroTavolo(nuovoNumero);
        return tavoloDao.save(tavolo);
    }

    //metodo che può far esplodere tutto
    public Tavolo updateOccupato(Long id, int occupato)
    {
        Tavolo tavolo = tavoloDao.findById(id).orElseThrow(() -> new RuntimeException("Tavolo non trovato"));
        tavolo.setOccupato(occupato);
        return tavoloDao.save(tavolo);
    }

    public void salvaBackupPosizioni(List<Map<String, Integer>> posizioni) {
        for (Map<String, Integer> pos : posizioni) {
            Long id = Long.valueOf(pos.get("id"));
            int x = pos.get("x");
            int y = pos.get("y");
            Tavolo tavolo = tavoloDao.findById(id).orElse(null);
            if (tavolo != null) {
                tavolo.setXBackup(x);
                tavolo.setYBackup(y);
                tavoloDao.save(tavolo);
            }
        }
    }

    public List<Map<String, Integer>> caricaBackupPosizioni() {
        return tavoloDao.findAll().stream()
                .map(t -> Map.of(
                        "id", t.getId().intValue(),
                        "x", t.getXBackup(),
                        "y", t.getYBackup()
                ))
                .collect(Collectors.toList());
    }
}


