package dao;

import jakarta.persistence.Id;
import models.ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ordineDao extends JpaRepository<ordine, Long>
{
	ordine findByIdOrdine(Long idOrdine);
}
