package org.example.gestaurant.models;

import jakarta.persistence.*;
import org.example.gestaurant.enums.Intolleranze;
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
    @Enumerated(EnumType.STRING)
    private Intolleranze intolleranze;



}
