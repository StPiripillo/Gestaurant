package org.example.gestaurant.dao;

import org.example.gestaurant.models.Ordine;
import org.example.gestaurant.models.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdottoDao extends JpaRepository<Prodotto, Long>
{

}
