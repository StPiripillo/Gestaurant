package org.example.gestaurant.dao;

import org.example.gestaurant.models.Ingredienti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientiDao extends JpaRepository<Ingredienti, Long>
{
}
