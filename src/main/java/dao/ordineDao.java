package dao;

import jakarta.persistence.Id;
import models.ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;

public interface ordineDao extends JpaRepository<Long, ordine>
{
	ordine findByIdOrdine(Long idOrdine);
}
