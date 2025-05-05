package models;

import enums.intolleranze;
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
public class ingredienti extends prodotto {
    private String nome;
    private double prezzoIngredienti;
    @ManyToOne
    @JoinColumn(name = "id_prodotto")
    private prodotto prodotto;
    @Enumerated
    private intolleranze intolleranze;



}
