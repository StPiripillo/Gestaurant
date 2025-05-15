package org.example.gestaurant.dao;

import org.example.gestaurant.models.Ordine;
import org.example.gestaurant.models.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

public interface OrdineDao extends JpaRepository<Ordine, Long>
{
	List<Ordine> findAllByTavoloId(Long id);
	@Transactional
	int deleteByTavolo_Id(Long tavoloId);

}
