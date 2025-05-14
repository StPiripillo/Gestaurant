package org.example.gestaurant.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gestaurant.enums.Dimensione;
import org.example.gestaurant.enums.Forma;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tavolo extends BaseEntity {
    private int numeroTavolo;
    @Enumerated (EnumType.STRING)
    private Forma forma;
    @Enumerated (EnumType.STRING)
    private Dimensione dimensione;
    private int posti;
    private int occupato;
    private int x;
    private int y;
    private int xBackup;
    private int yBackup;

   @OneToMany(mappedBy = "tavolo")
    private List<Ordine> ordini;

}
