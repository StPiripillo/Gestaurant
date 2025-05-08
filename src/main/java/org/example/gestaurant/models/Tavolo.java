package org.example.gestaurant.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tavolo extends BaseEntity {
//    private int numeroTAvolo;
    private int posti;
    private boolean occupato;
    private int x;
    private int y;

   @OneToMany(mappedBy = "tavolo")
    private List<Ordine> ordini;

}
