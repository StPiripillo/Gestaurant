package org.example.gestaurant.dao;

import org.example.gestaurant.models.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineDao extends JpaRepository<Ordine, Long>
{

}
