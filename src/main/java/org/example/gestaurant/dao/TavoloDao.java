package org.example.gestaurant.dao;

import org.example.gestaurant.models.tavolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TavoloDao extends JpaRepository<Tavolo, Long>
{

}
