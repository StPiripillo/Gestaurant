package models;

import enums.intolleranze;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class prodotto extends baseEntity {

	private String nome;
	private String descrizione;
	private double prezzo;
	@Enumerated
	private intolleranze intolleranze;
	@OneToMany(mappedBy = "prodotto", fetch = FetchType.EAGER)
	private List<ingredienti> ingredienti;
}
