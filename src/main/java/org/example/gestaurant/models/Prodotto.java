package org.example.gestaurant.models;
import org.example.gestaurant.enums.Intolleranze;
import org.example.gestaurant.enums.Tipologia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prodotto extends BaseEntity {

	private int qtn;
	private String nome;
	private String descrizione;
	private double prezzo;
	@Enumerated(EnumType.STRING)
	private Tipologia Tip;
	@Enumerated(EnumType.STRING)
	private Intolleranze intolleranze;
	@OneToMany(mappedBy = "prodotto", fetch = FetchType.EAGER)
	private List<Ingredienti> ingredienti = new ArrayList<>();

}
