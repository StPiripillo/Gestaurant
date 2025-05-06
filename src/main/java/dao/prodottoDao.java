package dao;

import models.prodotto;
import models.tavolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface prodottoDao extends JpaRepository<prodotto, Long>
{
    prodotto findByIProdotto (Long idProdotto);
}
