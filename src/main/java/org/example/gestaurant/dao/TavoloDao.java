package org.example.gestaurant.dao;

import org.example.gestaurant.models.Tavolo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TavoloDao extends JpaRepository<Tavolo, Long>
{
}
