package org.example.gestaurant.models;

import org.example.gestaurant.enums.Intolleranze;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredienti extends Prodotto {
    private String nome;
    private double prezzoIngredienti;
    @ManyToOne
    @JoinColumn(name = "id_prodotto")
    private Prodotto prodotto;
    @Enumerated
    private Intolleranze intolleranze;



}
