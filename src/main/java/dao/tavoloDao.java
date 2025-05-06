package dao;

import models.ordine;
import models.tavolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tavoloDao extends JpaRepository<tavolo, Long>
{
    tavolo findByIdTavolo (Long idTavolo);
}
