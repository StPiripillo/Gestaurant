package org.example.gestaurant.dao;

import org.example.gestaurant.models.ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ordineDao extends JpaRepository<ordine, Long>
{

}
