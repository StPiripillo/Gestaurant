package org.example.gestaurant.dao;

import org.example.gestaurant.models.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface OrdineDao extends JpaRepository<Ordine, Long>
{
	List<Ordine> findAllByTavoloId(Long id);
//	List<Ordine> findByTavoloIdTavolo(Long tavoloId);
}
