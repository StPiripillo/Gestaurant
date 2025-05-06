package org.example.gestaurant.dao;

import org.example.gestaurant.models.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoDao extends JpaRepository<Prodotto, Long>
{

}
