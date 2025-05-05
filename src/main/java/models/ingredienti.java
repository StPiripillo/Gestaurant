package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ingredienti extends prodotto {
    private String nome;
    private double prezzoIngredienti;
    @ManyToOne
    private prodotto prodotto;



}
