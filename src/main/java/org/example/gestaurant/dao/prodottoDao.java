package org.example.gestaurant.dao;

import org.example.gestaurant.models.prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface prodottoDao extends JpaRepository<prodotto, Long>
{

}
