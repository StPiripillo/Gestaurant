package org.example.gestaurant.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gestaurant.enums.Forma;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tavolo extends BaseEntity {
    private int numeroTavolo;
    private int dimensione;
    private int posti;
    @Enumerated (EnumType.STRING)
    private Forma forma;
    private boolean occupato;
    private int x;
    private int y;

   @OneToMany(mappedBy = "tavolo")
    private List<Ordine> ordini;

}
