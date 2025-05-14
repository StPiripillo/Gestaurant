package org.example.gestaurant.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ordine extends BaseEntity {
    private String nomeOrdine;
    private String noteOrdine;
    @ManyToOne
    @JoinColumn(name = "id_tavolo")
    private Tavolo tavolo;
    private double totale;

}
