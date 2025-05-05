package models;

import enums.intolleranze;
import enums.tipologia;
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
public class prodotto extends baseEntity {

	private int qtn;
	private String nome;
	private String descrizione;
	private double prezzo;
	@Enumerated
	private tipologia Tip;
	@Enumerated
	private intolleranze intolleranze;
	@OneToMany(mappedBy = "prodotto", fetch = FetchType.EAGER)
	private List<ingredienti> ingredienti = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "id_ordine")
	private ordine ordine;
}
